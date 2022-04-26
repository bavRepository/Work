package com.jsonplaceholder.typicode.model;

import java.util.Objects;

public class User implements IModel {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public Address getAddress() {
        return address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "{" + "\n\t" +
                "\"id\": " + id + ",\n\t" +
                "\"name\": " + name + ",\n\t" +
                "\"username\": " + username + ",\n\t" +
                "\"email\": " + email + ",\n\t" +
                "\"address\": " + address + ",\n\t" +
                "\"phone\": " + phone + ",\n\t" +
                "\"website\": " + website + ",\n\t" +
                "\"company\": " + company + ",\n" +
                " }" + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return name.equals(user.name) && username.equals(user.username) && email.equals(user.email) && address.equals(user.address) && phone.equals(user.phone) && website.equals(user.website) && company.equals(user.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, username, email, address, phone, website, company);
    }

    public static class Company {

        private String name;
        private String catchPhrase;
        private String bs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCatchPhrase() {
            return catchPhrase;
        }

        public void setCatchPhrase(String catchPhrase) {
            this.catchPhrase = catchPhrase;
        }

        public String getBs() {
            return bs;
        }

        public void setBs(String bs) {
            this.bs = bs;
        }

        @Override
        public String toString() {
            return "{" + "\n\t\t" +
                    "\"name\": " + name + ",\n\t\t" +
                    "\"catchPhrase\": " + catchPhrase + ",\n\t\t" +
                    "\"bs\": " + bs + ",\n\t" +
                    " }" + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Company)) return false;
            Company company = (Company) o;
            return name.equals(company.name) && catchPhrase.equals(company.catchPhrase) && bs.equals(company.bs);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, catchPhrase, bs);
        }
    }

    public static class Address {
        private String street;
        private String suite;
        private String city;
        private String zipcode;
        private Geo geo;

        public String getZipcode() {
            return zipcode;
        }

        public void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public Geo getGeo() {
            return geo;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getSuite() {
            return suite;
        }

        public void setSuite(String suite) {
            this.suite = suite;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        @Override
        public String toString() {
            return "{" + "\n\t\t" +
                    "\"street\": " + street + ",\n\t\t" +
                    "\"suite\": " + suite + ",\n\t\t" +
                    "\"city\": " + city + ",\n\t\t" +
                    "\"zipcode\": " + zipcode + ",\n\t\t" +
                    "\"geo\": " + geo + ",\n\t" +
                    " }" + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Address)) return false;
            Address address = (Address) o;
            return street.equals(address.street) && suite.equals(address.suite) && city.equals(address.city) && zipcode.equals(address.zipcode) && geo.equals(address.geo);
        }

        @Override
        public int hashCode() {
            return Objects.hash(street, suite, city, zipcode, geo);
        }
    }

    public static class Geo {

        private double lat;
        private double lng;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLng() {
            return lng;
        }

        public void setLng(double lng) {
            this.lng = lng;
        }

        @Override
        public String toString() {
            return "{" + "\n\t\t\t" +
                    "\"lat\": " + lat + ",\n\t\t\t" +
                    "\"lng\": " + lng + ",\n\t\t" +
                    " }" + "\n";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Geo)) return false;
            Geo geo = (Geo) o;
            return Double.compare(geo.lat, lat) == 0 && Double.compare(geo.lng, lng) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(lat, lng);
        }
    }
}
