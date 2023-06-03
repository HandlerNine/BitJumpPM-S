 package com.chenxf.DB.POJO;

public class User {
    private String UserID;
    private String Password;
    private String Email;
    private String Name;
    private String Gender;
    private String PhoneNumber;
    private String EntryTime; // Uncertain
    private String Department;
    private Integer Priv;
    private String Education;
    private String CensusRegister;
    private String Nationality;
    private String Marriage;
    private String BirthDate;
    private String Age;
    private String BloodType;
    private String PoliticalStatus;
    private String QQNumber;
    private String WechatNumber;
    private String Post;
    private String Address;
    private String School;
    private String Major;
    private String PreviousCompany;
    private String JobTitle;
    private String Limitation;
    private String PhotoUrl;
    private String Seniority;

    public User(){
    }

    public User(String userID, String password, String email, String name, String gender, String phoneNumber, String entryTime, String department, Integer priv, String education, String censusRegister, String nationality, String marriage, String birthDate, String age, String bloodType, String politicalStatus, String QQNumber, String wechatNumber, String post, String address, String school, String major, String previousCompany, String jobTitle, String limitation, String photoUrl, String seniority) {
        this.UserID = userID;
        this.Password = password;
        this.Email = email;
        this.Name = name;
        this.Gender = gender;
        this.PhoneNumber = phoneNumber;
        this.EntryTime = entryTime;
        this.Department = department;
        this.Priv = priv;
        this.Education = education;
        this.CensusRegister = censusRegister;
        this.Nationality = nationality;
        this.Marriage = marriage;
        this.BirthDate = birthDate;
        this.Age = age;
        this.BloodType = bloodType;
        this.PoliticalStatus = politicalStatus;
        this.QQNumber = QQNumber;
        this.WechatNumber = wechatNumber;
        this.Post = post;
        this.Address = address;
        this.School = school;
        this.Major = major;
        this.PreviousCompany = previousCompany;
        this.JobTitle = jobTitle;
        this.Limitation = limitation;
        this.PhotoUrl = photoUrl;
        this.Seniority = seniority;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getEntryTime() {
        return EntryTime;
    }

    public void setEntryTime(String entryTime) {
        EntryTime = entryTime;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public Integer getPriv() {
        return Priv;
    }

    public void setPriv(Integer priv) {
        Priv = priv;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getCensusRegister() {
        return CensusRegister;
    }

    public void setCensusRegister(String censusRegister) {
        CensusRegister = censusRegister;
    }

    public String getNationality() {
        return Nationality;
    }

    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    public String getMarriage() {
        return Marriage;
    }

    public void setMarriage(String marriage) {
        Marriage = marriage;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public String getPoliticalStatus() {
        return PoliticalStatus;
    }

    public void setPoliticalStatus(String politicalStatus) {
        PoliticalStatus = politicalStatus;
    }

    public String getQQNumber() {
        return QQNumber;
    }

    public void setQQNumber(String QQNumber) {
        this.QQNumber = QQNumber;
    }

    public String getWechatNumber() {
        return WechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        WechatNumber = wechatNumber;
    }

    public String getPost() {
        return Post;
    }

    public void setPost(String post) {
        Post = post;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getPreviousCompany() {
        return PreviousCompany;
    }

    public void setPreviousCompany(String previousCompany) {
        PreviousCompany = previousCompany;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String jobTitle) {
        JobTitle = jobTitle;
    }

    public String getLimitation() {
        return Limitation;
    }

    public void setLimitation(String limitation) {
        Limitation = limitation;
    }

    public String getPhotoUrl() {
        return PhotoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        PhotoUrl = photoUrl;
    }

    public String getSeniority() {
        return Seniority;
    }

    public void setSeniority(String seniority) {
        Seniority = seniority;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "UserID='" + UserID + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", EntryTime='" + EntryTime + '\'' +
                ", Department='" + Department + '\'' +
                ", Priv=" + Priv +
                ", Education='" + Education + '\'' +
                ", CensusRegister='" + CensusRegister + '\'' +
                ", Nationality='" + Nationality + '\'' +
                ", Marriage='" + Marriage + '\'' +
                ", BirthDate='" + BirthDate + '\'' +
                ", Age='" + Age + '\'' +
                ", BloodType='" + BloodType + '\'' +
                ", PoliticalStatus='" + PoliticalStatus + '\'' +
                ", QQNumber='" + QQNumber + '\'' +
                ", WechatNumber='" + WechatNumber + '\'' +
                ", Post='" + Post + '\'' +
                ", Address='" + Address + '\'' +
                ", School='" + School + '\'' +
                ", Major='" + Major + '\'' +
                ", PreviousCompany='" + PreviousCompany + '\'' +
                ", JobTitle='" + JobTitle + '\'' +
                ", Limitation='" + Limitation + '\'' +
                ", PhotoUrl='" + PhotoUrl + '\'' +
                ", Seniority='" + Seniority + '\'' +
                '}';
    }
}
