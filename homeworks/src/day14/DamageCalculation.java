package day14;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.*;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 * <p>
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 * 1-1. BARE_HANDS - 공격력 5
 * 1-2. DAGGER - 공격력 40
 * 1-3. LONG_SWORD - 공격력 100
 * 1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 * 2-1. BLACK_POTION - 공격력 10% 증가
 * 2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 * 2-3. MUSHROOM - 무기 공격력 + 20
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);
    Weapon(int dmg) {
        this.dmg = dmg;
    }
    private final int dmg;
    public int getDmg() {
        return dmg;
    }
}

enum Item {
    BLACK_POTION(v -> v * 1.1, false), WHITE_POTION(v -> v + 200, true), MUSHROOM(v -> v + 20, false);

    Item(DoubleUnaryOperator formula, boolean isStatic) {
        this.formula = formula;
        this.isStatic = isStatic;
    }

    private final boolean isStatic;
    private final DoubleUnaryOperator formula;

    public boolean isStatic() {
        return this.isStatic;
    }

    public DoubleUnaryOperator getFormula() {
        return formula;
    }
}

// TODO: Player에 필요한 메소드 구현
// 무기 교체, 아이템 사용, 아이템 효과 종료 메소드 구현
class Player {
    private Weapon currentWeapon;
    private final List<Item> items;
    private final List<Item> activeItems;
    private DoubleUnaryOperator formula;

    Player() {
        this(Weapon.BARE_HANDS);
    }

    Player(Weapon weapon) {
        this.currentWeapon = weapon;
        this.activeItems = new LinkedList<>();
        this.items = new LinkedList<>();
        this.formula = x -> x;
    }

    public void changeWeapon(Weapon weapon) {
        this.currentWeapon = weapon;
    }

    public void usePotion(Item item) {
        if (this.items.contains(item)) {
            this.items.remove(item);
            if (item.isStatic()) {
                activeItems.add(item);
            } else {
                activeItems.add(getNonStaticIndex(), item);
            }
            updateFormula();
        } else {
            throw new NoSuchElementException(String.format("%s not found in inventory\n", item.name()));
        }
    }

    private int getNonStaticIndex() {
        int targetIdx = activeItems.indexOf(Item.WHITE_POTION);
        return targetIdx < 0 ? activeItems.size() : targetIdx;
    }

    public double getCurrentDmg() {
        return formula.applyAsDouble(this.currentWeapon.getDmg());
    }

    public void disableItem(Item item) {
        this.activeItems.remove(item);
        updateFormula();
    }

    public void addItems(Item... items) {
        this.items.addAll(Arrays.asList(items));
    }

    public void updateFormula() {
        if (this.activeItems.size() > 0) {
            this.formula = activeItems
                    .stream()
                    .map(Item::getFormula)
                    .reduce(DoubleUnaryOperator::andThen)
                    .get();
        } else {
            this.formula = x -> x;
        }
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        BiConsumer<Double, Double> testConsumer = (expected, actual) -> {
            System.out.printf("expected: %.3f actual: %.3f\t%s%n", expected, actual, expected.equals(actual) ? "SUCCESS" : "FAIL");
        };

        Player player = new Player();
        player.addItems(Item.BLACK_POTION);
        testConsumer.accept((double) 5, player.getCurrentDmg());
        player.usePotion(Item.BLACK_POTION);
        testConsumer.accept(5.5, player.getCurrentDmg());
        player.changeWeapon(Weapon.DRAGON_SLAYER);
        testConsumer.accept((double) 275, player.getCurrentDmg());
        player.disableItem(Item.BLACK_POTION);
        testConsumer.accept((double) 250, player.getCurrentDmg());
        player.addItems(Item.BLACK_POTION, Item.MUSHROOM, Item.WHITE_POTION);
        player.usePotion(Item.MUSHROOM);
        player.usePotion(Item.BLACK_POTION);
        player.usePotion(Item.WHITE_POTION);
        testConsumer.accept((double) 497, player.getCurrentDmg());
    }
}