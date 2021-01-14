package com.github.cc3002.finalreality.model.weapon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

  private static final String AXE_NAME = "Test Axe";
  private static final String STAFF_NAME = "Test Staff";
  private static final String SWORD_NAME = "Test Sword";
  private static final String BOW_NAME = "Test Bow";
  private static final String KNIFE_NAME = "Test Knife";
  private static final int DAMAGE = 15;
  private static final int SPEED = 10;

  private Weapon testAxe;
  private Weapon testStaff;
  private Weapon testSword;
  private Weapon testBow;
  private Weapon testKnife;
  private Weapon testWeapon;

  @BeforeEach
  void setUp() {
    testAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    testStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    testSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    testBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    testKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);
  }

  @Test
  void constructorTest() {
    var expectedAxe = new Axe(AXE_NAME, DAMAGE, SPEED);
    var expectedStaff = new Staff(STAFF_NAME, DAMAGE, SPEED);
    var expectedSword = new Sword(SWORD_NAME, DAMAGE, SPEED);
    var expectedBow = new Bow(BOW_NAME, DAMAGE, SPEED);
    var expectedKnife = new Knife(KNIFE_NAME, DAMAGE, SPEED);

    assertEquals(expectedAxe, testAxe);
    assertEquals(expectedAxe.hashCode(), testAxe.hashCode());
    assertEquals(testAxe, testAxe);
    assertNotEquals(testAxe, testBow );
    assertNotEquals(testAxe, new Axe("MalNombre", DAMAGE, SPEED) );
    assertNotEquals(testAxe, new Axe(AXE_NAME, 0, SPEED) );
    assertNotEquals(testAxe, new Axe(AXE_NAME, DAMAGE, 0) );

    assertEquals(expectedStaff, testStaff);
    assertEquals(expectedStaff.hashCode(), testStaff.hashCode());
    assertEquals(testStaff, testStaff);
    assertNotEquals(testStaff, testAxe );
    assertNotEquals(testStaff, new Staff("MalNombre", DAMAGE, SPEED));
    assertNotEquals(testStaff, new Staff(STAFF_NAME, 0, SPEED) );
    assertNotEquals(testStaff, new Staff(STAFF_NAME, DAMAGE, 0) );

    assertEquals(expectedSword, testSword);
    assertEquals(expectedSword.hashCode(), testSword.hashCode());
    assertEquals(testSword, testSword);
    assertNotEquals(testSword, testAxe );
    assertNotEquals(testSword, new Sword("MalNombre", DAMAGE, SPEED) );
    assertNotEquals(testSword, new Sword(SWORD_NAME, 0, SPEED) );
    assertNotEquals(testSword, new Sword(SWORD_NAME, DAMAGE, 0) );

    assertEquals(expectedBow, testBow);
    assertEquals(expectedBow.hashCode(), testBow.hashCode());
    assertEquals(testBow, testBow);
    assertNotEquals(testBow, testAxe );
    assertNotEquals(testBow, new Bow("MalNombre", DAMAGE, SPEED) );
    assertNotEquals(testBow, new Bow(BOW_NAME, 0, SPEED) );
    assertNotEquals(testBow, new Bow(BOW_NAME, DAMAGE, 0) );

    assertEquals(expectedKnife, testKnife);
    assertEquals(expectedKnife.hashCode(), testKnife.hashCode());
    assertEquals(testKnife, testKnife);
    assertNotEquals(testKnife, testAxe );
    assertNotEquals(testKnife, new Knife("MalNombre", DAMAGE, SPEED) );
    assertNotEquals(testKnife, new Knife(KNIFE_NAME, 0, SPEED) );
    assertNotEquals(testKnife, new Knife(KNIFE_NAME, DAMAGE, 0) );

    assertEquals(testKnife.getDamage(),DAMAGE);
    testKnife.setDamage(30);
    assertEquals(testKnife.getDamage(),30);
    assertEquals(testKnife.getWeight(),SPEED);
    testKnife.setWeight(30);
    assertEquals(testKnife.getWeight(),30);
  }
}