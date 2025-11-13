package com.rafikiroast.models;

import java.util.ArrayList;
import java.util.List;

public class OrderItem {
    private BaseOptions base;
    private List<Proteins> proteins = new ArrayList<>();
    private List<PremiumAddOns> premiumAddOns = new ArrayList<>();
    private List<Toppings> toppings = new ArrayList<>();
    private List<Sauces> sauces = new ArrayList<>();
    private boolean isCustomized;
    private double totalPrice;

    public OrderItem(BaseOptions base, List<Proteins> proteins, List<PremiumAddOns> premiumAddOns, List<Toppings> toppings, List<Sauces> sauces, boolean isCustomized, double totalPrice) {
        this.base = base;
        this.proteins = proteins;
        this.premiumAddOns = premiumAddOns;
        this.toppings = toppings;
        this.sauces = sauces;
        this.isCustomized = isCustomized;
        this.totalPrice = totalPrice;
    }

    public void addProtein(Proteins protein) {
        proteins.add(protein);
        totalPrice += protein.getExtraCost();
    }

    public void addPremiumAddon(PremiumAddOns premiumAddOn) {
        premiumAddOns.add(premiumAddOn);
        totalPrice += premiumAddOn.getExtraCost();
    }

    public void addTopping(Toppings topping) {
        toppings.add(topping);
    }

    public void addSauce(Sauces sauce) {
        sauces.add(sauce);
    }

    public void setCustomized(boolean customized) {
        isCustomized = customized;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("OrderItem{");
        sb.append(base.toString()).append("\n");

        if (!proteins.isEmpty()) {
            sb.append("Proteins: ");
            for (Proteins proteins1 : proteins)
                sb.append(proteins1.getName()).append(", ");
            //remove comma
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        if (!premiumAddOns.isEmpty()) {
            sb.append("Premium Add-Ons: ");
            for (PremiumAddOns p : premiumAddOns) sb.append(p.getName()).append(", ");
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        if (!toppings.isEmpty()) {
            sb.append("Toppings: ");
            for (Toppings t : toppings) sb.append(t.getName()).append(", ");
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        if (!sauces.isEmpty()) {
            sb.append("Sauces: ");
            for (Sauces s : sauces) sb.append(s.getName()).append(", ");
            sb.setLength(sb.length() - 2);
            sb.append("\n");
        }

        if (isCustomized) sb.append("Customized Option Applied\n");

        sb.append("Item Total: $").append(String.format("%.2f", totalPrice)).append("\n");
        return sb.toString();
    }
}


