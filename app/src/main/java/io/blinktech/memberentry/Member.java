package io.blinktech.memberentry;

/**
 * Created by mayank on 7/21/15.
 */
public class Member {
    private int memberId;
    private int familyId;
    private String name;
    private int age;
    private int childId;
    private String marriageStatus;
    private String familyPlan;
    private String education;
    private String literacy;
    private String weddingArr;
    private String weddingDept;

    public Member() {
    }

    public Member(int memberId, int familyId, String name, int age, int childId, String marriageStatus, String familyPlan, String education, String literacy, String weddingArr, String weddingDept) {
        this.memberId = memberId;
        this.familyId = familyId;
        this.name = name;
        this.age = age;
        this.childId = childId;
        this.marriageStatus = marriageStatus;
        this.familyPlan = familyPlan;
        this.education = education;
        this.literacy = literacy;
        this.weddingArr = weddingArr;
        this.weddingDept = weddingDept;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(String marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public String getFamilyPlan() {
        return familyPlan;
    }

    public void setFamilyPlan(String familyPlan) {
        this.familyPlan = familyPlan;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getLiteracy() {
        return literacy;
    }

    public void setLiteracy(String literacy) {
        this.literacy = literacy;
    }

    public String getWeddingArr() {
        return weddingArr;
    }

    public void setWeddingArr(String weddingArr) {
        this.weddingArr = weddingArr;
    }

    public String getWeddingDept() {
        return weddingDept;
    }

    public void setWeddingDept(String weddingDept) {
        this.weddingDept = weddingDept;
    }
}
