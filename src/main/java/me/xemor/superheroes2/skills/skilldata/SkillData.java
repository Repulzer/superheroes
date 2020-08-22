package me.xemor.superheroes2.skills.skilldata;

import jdk.internal.jline.internal.Nullable;
import me.xemor.superheroes2.skills.Skill;
import org.bukkit.configuration.ConfigurationSection;

public abstract class SkillData {

    private Skill skill;
    private ConfigurationSection configurationSection;

    protected SkillData(Skill skill, ConfigurationSection configurationSection) {
        this.skill = skill;
        this.configurationSection = configurationSection;
    }

    @Nullable
    public static SkillData create(Skill skill, ConfigurationSection configurationSection) {
        switch (skill) {
            case INSTANTBREAK: return new InstantBreakData(skill, configurationSection);
            case POTIONEFFECT:
            case SNEAKINGPOTION:
                return new PotionEffectData(skill, configurationSection);
            case LIGHT: return new LightData(skill, configurationSection);
            case NOHUNGER: return new BlankData(skill, configurationSection);
            case ELECTRIFIED: return new ElectrifiedData(skill, configurationSection);
            case SLIME: return new SlimeData(skill, configurationSection);
            case AEROSURFER: return new AerosurferData(skill, configurationSection);
            case EGGLAYER: return new EggLayerData(skill, configurationSection);
            case AURA: return new AuraData(skill, configurationSection);
            case WALKER: return new WalkerData(skill, configurationSection);
            default: return null;
        }
    }

    public ConfigurationSection getData() {
        return configurationSection;
    }

    public Skill getSkill() {
        return skill;
    }

}