package com.example.foodordering1;

public class Profile {
    private  String name;
    private  String Price;
    private  String profilePic;
    private  Boolean Permission;

    public Profile(){}

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", Price='" + Price + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", Permission=" + Permission +
                '}';
    }

    public Profile(String name,String price,String profilePic,Boolean permission) {
        this.name = name;
        Price = price;
        this.profilePic = profilePic;
        Permission = permission;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getPrice() {
        return Price;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setPermission(Boolean permission) {
        Permission = permission;
    }

    public Boolean getPermission() {
        return Permission;
    }
}
