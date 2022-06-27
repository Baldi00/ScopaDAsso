package scopadasso.model;

import java.util.Objects;

public class Card implements Comparable{
    private final Value value;
    private final Seed seed;

    public Card(Value value, Seed seed) {
        this.value = value;
        this.seed = seed;
    }

    public Value getValue() {
        return value;
    }

    public Seed getSeed() {
        return seed;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.value);
        hash = 17 * hash + Objects.hashCode(this.seed);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.value != other.value) {
            return false;
        }
        if (this.seed != other.seed) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Card{" + "value=" + value + ", seed=" + seed + '}';
    }

    @Override
    public int compareTo(Object o) {
        int compareValue = value.compareTo(((Card)o).value);
        if(compareValue == 0) {
            return seed.compareTo(((Card)o).seed);
        }
        return compareValue;
    }
}
