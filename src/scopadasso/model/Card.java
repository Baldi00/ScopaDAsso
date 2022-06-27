/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scopadasso.model;

import java.util.Objects;

/**
 *
 * @author Andrea
 */
public class Card {
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
}
