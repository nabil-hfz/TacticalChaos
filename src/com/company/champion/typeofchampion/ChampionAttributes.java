package com.company.champion.typeofchampion;

import com.google.gson.annotations.SerializedName;

public abstract class ChampionAttributes {
    @SerializedName("Champion")
    private String ChampionName;

    @SerializedName("Class1")
    private String Class1;

    @SerializedName("Class2")
    private String Class2;

    @SerializedName("Class3")
    private String Class3;

    @SerializedName("GoldCost")
    private String GoldCost;

    @SerializedName("Health")
    private String Health;

    @SerializedName("Armor")
    private String Armor; //درع

    @SerializedName("Magic resist")
    private String MagicResist; // يقلل من امكانيات هجوم العدو

    @SerializedName("Vision range")
    private String VisionRange; // المنطقة المكشوفة للاعب

    @SerializedName("Attack range")
    private String AttackRange;

    @SerializedName("AttackDamage")
    private String AttackDamage;

    @SerializedName("Movement speed")
    private String MovementSpeed;

    @SerializedName("Critical strike chance")
    private String CriticalStrikeChance; //احتمالية الحاق الأذى بالعدو مثلا عندما يكون قريب

    @SerializedName("Critical strike damage")
    private String CriticalStrikeDamage; // يتحول الهجوم العادي الى critical

    @SerializedName("Mana Start")
    private String ManaStart; //=Ability charge تبدأ صفر وتزداد عندما يتلقى البطل ضرر

    @SerializedName("Mana Cost")
    private String ManaCost;

    @SerializedName("Ability")
    private String Ability;

    private int mManaBurnCost;

    private boolean mStopAbilityDamageForDragons;

    private boolean mDoubleAttackWithImperial;

    private int mBladeMasterNumber;

    private boolean mRangerDoubleAttackRanger;

    private boolean mBrawlerExtraHealth;

    private int mElementalist;

    private boolean mTenthPlaceFromElementalistBuff;

    public boolean isTenthPlaceFromElementalistBuff() {
        return mTenthPlaceFromElementalistBuff;
    }

    public void setTenthPlaceFromElementalistBuff(boolean tenthPlaceFromElementalistBuff) {
        mTenthPlaceFromElementalistBuff = tenthPlaceFromElementalistBuff;
    }

    public int getElementalist() {
        return mElementalist;
    }

    public void setElementalist(int mElementalist) {
        this.mElementalist = mElementalist;
    }

    public boolean isBrawlerExtraHealth() {
        return mBrawlerExtraHealth;
    }

    public void setBrawlerExtraHealth(boolean mBrawlerExtraHealth) {
        this.mBrawlerExtraHealth = mBrawlerExtraHealth;
    }

    public boolean isRangerDoubleAttackRanger() {
        return mRangerDoubleAttackRanger;
    }

    public void setRangerDoubleAttackRanger(boolean mRangerDoubleAttackRanger) {
        this.mRangerDoubleAttackRanger = mRangerDoubleAttackRanger;
    }

    public int getBladeMasterNumber() {
        return mBladeMasterNumber;
    }

    public void setBladeMasterNumber(int mBladeMasterNumber) {
        this.mBladeMasterNumber = mBladeMasterNumber;
    }

    public boolean isStopAbilityDamageForDragons() {
        return mStopAbilityDamageForDragons;
    }

    public void setStopAbilityDamageForDragons(boolean mStopAbilityDamageForDragons) {
        this.mStopAbilityDamageForDragons = mStopAbilityDamageForDragons;
    }

    public boolean ismDoubleAttackWithImperial() {
        return mDoubleAttackWithImperial;
    }

    public void setDoubleAttackWithImperial(boolean mDoubleAttackWithImperial) {
        this.mDoubleAttackWithImperial = mDoubleAttackWithImperial;
    }

    public int getManaBurnCost() {
        return mManaBurnCost;
    }

    public void setManaBurnCost(int mManaBurnCost) {
        this.mManaBurnCost = mManaBurnCost;
    }

    public String getChampionName() {
        return ChampionName;
    }

    public void setChampionName(String championName) {
        ChampionName = championName;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        Class1 = class1;
    }

    public String getClass2() {
        return Class2;
    }

    public void setClass2(String class2) {
        Class2 = class2;
    }

    public String getClass3() {
        return Class3;
    }

    public void setClass3(String class3) {
        Class3 = class3;
    }

    public String getGoldCost() {
        return GoldCost;
    }

    public void setGoldCost(String goldCost) {
        GoldCost = goldCost;
    }

    public String getHealth() {
        return Health;
    }

    public void setHealth(String health) {
        Health = health;
    }

    public String getArmor() {
        return Armor;
    }

    public void setArmor(String armor) {
        Armor = armor;
    }

    public String getMagicResist() {
        return MagicResist;
    }

    public void setMagicResist(String magicResist) {
        MagicResist = magicResist;
    }

    public String getVisionRange() {
        return VisionRange;
    }

    public void setVisionRange(String visionRange) {
        VisionRange = visionRange;
    }

    public String getAttackRange() {
        return AttackRange;
    }

    public void setAttackRange(String attackRange) {
        AttackRange = attackRange;
    }

    public String getAttackDamage() {
        return AttackDamage;
    }

    public void setAttackDamage(String attackDamage) {
        AttackDamage = attackDamage;
    }

    public String getMovementSpeed() {
        return MovementSpeed;
    }

    public void setMovementSpeed(String movementSpeed) {
        MovementSpeed = movementSpeed;
    }

    public String getCriticalStrikeChance() {
        return CriticalStrikeChance;
    }

    public void setCriticalStrikeChance(String criticalStrikeChance) {
        CriticalStrikeChance = criticalStrikeChance;
    }

    public String getCriticalStrikeDamage() {
        return CriticalStrikeDamage;
    }

    public void setCriticalStrikeDamage(String criticalStrikeDamage) {
        CriticalStrikeDamage = criticalStrikeDamage;
    }

    public String getManaStart() {
        return ManaStart;
    }

    public void setManaStart(String manaStart) {
        ManaStart = manaStart;
    }

    public String getManaCost() {
        return ManaCost;
    }

    public void setManaCost(String manaCost) {
        ManaCost = manaCost;
    }

    public String getAbility() {
        return Ability;
    }

    public void setAbility(String ability) {
        Ability = ability;
    }
}