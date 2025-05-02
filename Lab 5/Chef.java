package Lab5;
class Chef {
    public void makeSpecialDish() {
        System.out.println("Making a generic special dish.");
    }
}

class ItalianChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making pasta.");
    }
}

class ChineseChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making dumplings.");
    }
}

class MexicanChef extends Chef {
    @Override
    public void makeSpecialDish() {
        System.out.println("Making tacos.");
    }
}

