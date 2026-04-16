import java.util.*;

class Parcel {
    private String parcelId;
    private char zone;
    private int weight;
    public Parcel(String parcelId, char zone, int weight) {
        this.parcelId = parcelId;
        this.zone = zone;
        this.weight = weight;
    }
    public String getParcelId() {
        return this.parcelId;
    }
    public char getZone() {
        return this.zone;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setParcelId(String parcelId) {
        this.parcelId = parcelId;
    }
    public void setZone(char zone) {
        this.zone = zone;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void print() {
        System.out.printf("[%s] (%c) {%d}kg\n", this.parcelId, this.zone, this.weight);
    }
    static class comparator implements Comparator<Parcel> {
        @Override
        public int compare(Parcel p1, Parcel p2) {
            int ZoneCompare = p1.getZone() - p2.getZone();
            if (ZoneCompare != 0) return ZoneCompare;
            else {
                int WeightCompare = p2.getWeight() - p1.getWeight();
                if (WeightCompare != 0) return WeightCompare;
                else return p1.getParcelId().compareTo(p2.getParcelId());
            }
        }
    }
}

class DeliveryBox {
    private Parcel parcel1;
    private Parcel parcel2;
    private char zone;
    public DeliveryBox(Parcel parcel1, Parcel parcel2, char zone) {
        this.parcel1 = parcel1;
        this.parcel2 = parcel2;
        this.zone = zone;
    }
    public DeliveryBox(Parcel parcel, char zone) {
        this.parcel1 = parcel;
        this.parcel2 = null;
        this.zone = zone;
    }
    public Parcel getParcel1() {
        return this.parcel1;
    }
    public Parcel getParcel2() {
        return this.parcel2;
    }
    public char getZone() {
        return this.zone;
    }
    public void setParcel1(Parcel parcel1) {
        this.parcel1 = parcel1;
    }
    public void setParcel2(Parcel parcel2) {
        this.parcel2 = parcel2;
    }
    public void setZone(char zone) {
        this.zone = zone;
    }
    public boolean isValidBox() {
        if (this.parcel2 == null) {
            return parcel1.getZone() == this.zone;
        } else {
            return parcel1.getZone() == this.zone &&  parcel2.getZone() == this.zone;
        }
    }
    public void print() {
        if (parcel2 == null) {
            System.out.printf("%c_%s_Empty\n", parcel1.getZone(), parcel1.getParcelId());
        }  else {
            if (parcel1.getWeight() > parcel2.getWeight()) {
                System.out.printf("%c_%s_%s\n", parcel1.getZone(), parcel2.getParcelId(), parcel1.getParcelId());
            } else if (parcel1.getWeight() < parcel2.getWeight()) {
                System.out.printf("%c_%s_%s\n", parcel1.getZone(), parcel1.getParcelId(), parcel2.getParcelId());
            } else {
                if (parcel1.getParcelId().compareTo(parcel2.getParcelId()) >= 0) {
                    System.out.printf("%c_%s_%s\n", parcel1.getZone(), parcel2.getParcelId(), parcel1.getParcelId());
                } else  {
                    System.out.printf("%c_%s_%s\n", parcel1.getZone(), parcel1.getParcelId(), parcel2.getParcelId());
                }
            }
        }
    }
}

class LogisticsSystem {
    public static Parcel[] check(Parcel[] allParcels, DeliveryBox[] boxes) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();
        List<Parcel> invalidParcelIds = new ArrayList<>();
        for (DeliveryBox box : boxes) {
            if (!box.isValidBox()) {
                if (box.getParcel1() != null) invalidParcelIds.add(box.getParcel1());
                if (box.getParcel2() != null) invalidParcelIds.add(box.getParcel2());
            }
            map.put(box.getParcel1().getParcelId(), map.getOrDefault(box.getParcel1().getParcelId(), 0) + 1);
            if (box.getParcel2() != null) map.put(box.getParcel2().getParcelId(), map.getOrDefault(box.getParcel2().getParcelId(), 0) + 1);
        }
        for (Parcel parcel : allParcels) {
            if (!map.containsKey(parcel.getParcelId()) || map.get(parcel.getParcelId()) > 1) {
                invalidParcelIds.add(parcel);
            }
        }
        invalidParcelIds = new ArrayList<>(new LinkedHashSet<> (invalidParcelIds));
        return invalidParcelIds.toArray(new Parcel[0]);
    }
    public static DeliveryBox[] autoPack(Parcel[] Parcels) {
        List<DeliveryBox> boxes = new ArrayList<>();
        Arrays.sort(Parcels, new Parcel.comparator());
        int i = 0;
        while (i < Parcels.length) {
            if (i == Parcels.length - 1) {
                boxes.add(new DeliveryBox(Parcels[i], Parcels[i].getZone()));
                i++;
            } else if (Parcels[i].getZone() == Parcels[i+1].getZone()) {
                boxes.add(new DeliveryBox(Parcels[i], Parcels[i+1],  Parcels[i+1].getZone()));
                i += 2;
            } else {
                boxes.add(new DeliveryBox(Parcels[i], Parcels[i].getZone()));
                i++;
            }
        }
        return boxes.toArray(new DeliveryBox[0]);
    }
}
