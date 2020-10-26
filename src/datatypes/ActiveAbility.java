package datatypes;

public class ActiveAbility {
    private String abilityManaCost;
    private String abilityRuleText;

    public ActiveAbility(String manaCost, String ruleText){
        this.abilityManaCost = manaCost;
        this.abilityRuleText = ruleText;
    }

    public String getAbilityManaCost() {
        return abilityManaCost;
    }

    public String getAbilityRuleText() {
        return abilityRuleText;
    }
}
