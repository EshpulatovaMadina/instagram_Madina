package uz.pdp.instagram.domain.model;

public class User extends BaseModel{
    private String name;
    private String phoneNum;
    private String password;

    public User(UserBuilder userBuilder) {
        this.name = userBuilder.name;
        this.password = userBuilder.password;
        this.phoneNum = userBuilder.phoneNum;
    }

    public static class UserBuilder{
        private String name;
        private String phoneNum;
        private String password;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
