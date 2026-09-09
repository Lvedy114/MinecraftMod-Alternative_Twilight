package com.alternative_twilight.at_mod.boss.lich;

/**
 * 巫妖三阶段战斗机制的业务逻辑（普通域类，不含 Mixin）。
 *
 * <p>Mixin 层（{@code mixin/lich/LichMixin}）只做挂钩，计算集中在本类，便于测试与版本迁移。
 *
 * <p>待实现的机制（见 docs/需求.md §2.1，数值取自 Config 的 lich 节）：
 * <ul>
 *   <li>第一阶段：每失去一格护盾，对破盾者施加/逐级叠加嗜血诅咒
 *       （首次时长 {@code LICH_BLOOD_LUST_CURSE_DURATION}）</li>
 *   <li>第二阶段：受到的伤害限定为 1 点；场上忠诚僵尸 ≥3 时受击立即进入第三阶段</li>
 *   <li>第三阶段进入：清除场上全部忠诚僵尸，每只失去 {@code 相当于自身10%最大生命值} 的生命
 *       （合计上限 {@code 50%}）并获得一级永久嗜血；获得生命/护甲/护甲韧性加成</li>
 *   <li>第三阶段战斗：周期性（{@code LICH_PHASE3_MAGIC_ORB_INTERVAL}）召唤法球，短暂延迟后射出；
 *       生命值低于阈值（{@code LICH_PHASE3_ORB_COUNT_THRESHOLD}）时数量由 3 提升至 6</li>
 * </ul>
 */
public final class LichPhaseManager {

    private LichPhaseManager() {
    }

    // TODO: 从旧 LichMixin 迁移各阶段计算方法（破盾诅咒、伤害锁定、清场代价、属性加成、法球召唤）。
    //  建议方法签名形如：
    //  - onShieldBreak(Lich lich, LivingEntity attacker) —— 第一阶段
    //  - onPhase2Damaged(Lich lich) —— 第二阶段
    //  - enterPhase3(Lich lich) —— 第三阶段进入（清场、扣血、加成）
    //  - tickPhase3(Lich lich) —— 第三阶段战斗（法球召唤冷却）
}
