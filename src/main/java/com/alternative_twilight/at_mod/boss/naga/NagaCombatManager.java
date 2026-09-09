package com.alternative_twilight.at_mod.boss.naga;

/**
 * 娜迦战斗机制的业务逻辑（普通域类，不含 Mixin）。
 *
 * <p>Mixin 层（{@code mixin/naga/NagaMixin}）只做挂钩，计算集中在本类。
 *
 * <p>待实现的机制（见 docs/需求.md §2.2，数值取自 Config 的 naga 节）：
 * <ul>
 *   <li>冲撞毒液：每次普通冲撞/愤怒冲撞向目标方向发射 {@code VENOM_COUNT} 发毒液，
 *       触地后滞留 {@code VENOM_LINGER_TICKS} 并对周围生物造成持续伤害
 *       （伤害类型 {@code at_mod:naga_venom}，投射物实体待登记于 ModEntityTypes）</li>
 *   <li>愤怒阈值：生命低于 {@code PHASE2_HEALTH_RATIO}（默认 66%）时愤怒冲撞替代全部普通冲撞，
 *       低于 {@code PHASE3_HEALTH_RATIO}（默认 33%）时连续愤怒冲撞</li>
 *   <li>眩晕反制：愤怒冲刺期间受到正面攻击且攻击者相对速度大于 {@code DAZE_SPEED_THRESHOLD}
 *       时陷入眩晕；眩晕/非眩晕状态的受伤倍率见对应配置</li>
 * </ul>
 */
public final class NagaCombatManager {

    private NagaCombatManager() {
    }

    // TODO: 从旧 NagaMixin / NagaMovementPatternMixin 迁移计算方法（毒液弹道与滞留、阶段阈值、眩晕判定）。
    //  建议方法签名形如：
    //  - onCharge(Naga naga, LivingEntity target) —— 冲撞时发射毒液
    //  - shouldEnragedCharge(Naga naga) —— 按生命阈值判定愤怒冲撞
    //  - tryDaze(Naga naga, DamageSource source) —— 正面攻击的眩晕判定
}
