package Model;

public class Item {
        private String name,price,image;
        public Item(String name,String price,String image)
        {
            this.name = name;
            this.price = price;
            this.image= image;
        }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getPrice() {
        return price;
    }
}
