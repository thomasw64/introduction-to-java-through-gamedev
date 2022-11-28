package net.middlemind.DungeonTrap_Chapter8_Challenge2_Solved;

import net.middlemind.MmgGameApiJava.MmgBase.MmgBmpScaler;
import net.middlemind.MmgGameApiJava.MmgBase.MmgHelper;
import net.middlemind.MmgGameApiJava.MmgBase.MmgVector2;

/**
 * A class that represents a weapon of type spear.
 * 
 * @author Victor G. Brusca, Middlemind Games
 * 09/19/2020
 */
public class MdtWeaponSpearFlame extends MdtWeaponSpear {

    /*********************************************************
    ****************** CHAPTER 8 CHALLENGE 2 *****************
    **********************************************************
    * Description: 
    * Find the package, net.middlemind.DungeonTrap_Chapter8_Challenge2, and open the MdtWeaponSpearFlame.java file.
    * This challenge is another of the more complicated challenges and as such you'll need to look at code in the 
    * following Java classes:
    * 
    * MdtWeaponSpearFlame.java
    * MdtWeapon.java
    * ScreenGame.java
    * MdtWeaponAxe.java
    * 
    * Some of the developers like the new spear but think it's too similar to the original spear. They want to test
    * out making the spear shoot out, like a throwing weapon, instead. In order to implement this change, you'll need
    * make a few adjustments to the code. There's a weapon that exists as a throwing weapon, the MdtWeaponAxe.java class.
    * There are a few methods that we need to use from this class to make our weapon throwable. First, you'll need to copy
    * and paste the following methods from the MdtWeaponAxe.java file to the MdtWeaponSpearFlame.java file.
    * 
    * GetX();
    * SetX(int i);
    * GetY();
    * SetY(int i);
    * SetPosition(MmgVector2 v);
    * SetPosition(int x, int y);
    * 
    * This will allow the new flame spear to handle setting its X, Y coordinate or position in the same way the axe, a
    * throwable weapon, does. Next, we'll need to adjust the super class of all weapons, the MdtWeapon class to support
    * the new throwable spear. Find the following methods in this class.
    * 
    * GetWeaponRect()
    * MmgDraw(MmgPen p)
    * 
    * There are special branches of code to handle a throwing axe, expand the two if statements to support throwable axes
    * and spears. A similar change must be made to the ScreenGame.java class' ProcessAClick method. Find the two places in the
    * method where you have to alter an if statement to include throwable spears, not just axes. Making these adjustments will 
    * make the new spear fly out and rotate, if implemented properly. You must run this package's file - DungeonTrap.java - 
    * right-click and select Run-File, to test the game.
    * 
    * Clue:
    * This is a tough challenge and there's not much in the way of a clue to guide you if you run into trouble. 
    * Carefully read through the classes and methods provided in the description. Keep an eye out for the different
    * behavior of the axe in the code and keep in mind your making a throwing spear, so it will function the same way as
    * the axe.
    * 
    * Search for "CHAPTER 8 CHALLENGE 2 SOLUTION" in the challenge's package to find the changes made to solve this challenge.
    * Similarly, you could limit your text search to the files associated with this challenge, listed previously.
    */ 
    
    /**
     * A basic constructor that allows you to set the weapon holder and weapon type via constructor arguments.
     * 
     * @param Holder        The holder of the weapon.
     * @param WeaponType    The type of weapon held.
     * @param Player        The type of player that is holding the weapon.
     */
    public MdtWeaponSpearFlame(MdtChar Holder, MdtWeaponType WeaponType, MdtPlayerType Player) {
        super(Holder, WeaponType, Player);
        subjFront = MmgHelper.GetBasicCachedBmp("weapon_spear_flame_dir_front.png");
        subjFront = MmgBmpScaler.ScaleMmgBmp(subjFront, 2.0f, true);
        
        subjBack = MmgHelper.GetBasicCachedBmp("weapon_spear_flame_dir_back.png");        
        subjBack = MmgBmpScaler.ScaleMmgBmp(subjBack, 2.0f, true);
        
        subjLeft = MmgHelper.GetBasicCachedBmp("weapon_spear_flame_dir_left.png");
        subjLeft = MmgBmpScaler.ScaleMmgBmp(subjLeft, 2.0f, true);
        
        subjRight = MmgHelper.GetBasicCachedBmp("weapon_spear_flame_dir_right.png");
        subjRight = MmgBmpScaler.ScaleMmgBmp(subjRight, 2.0f, true);
        
        SetMdtType(MdtObjType.WEAPON);
        SetMdtSubType(MdtObjSubType.WEAPON_SPEAR);
        SetAttackType(MdtWeaponAttackType.THROWING);
        SetWidth(subjBack.GetHeight());
        SetHeight(subjBack.GetHeight());
        SetDamage(2);
        SetAnimTimeMsTotal(350);
    }
    
    /**
     * Creates a clone of this object instance.
     * 
     * @return  A new instance of this class.
     */
    @Override
    public MdtWeaponSpearFlame Clone() {
        MdtWeaponSpearFlame ret = new MdtWeaponSpearFlame(holder, weaponType, player);
        ret.SetAnimPrctComplete(GetAnimPrctComplete());
        ret.SetIsActive(GetIsActive());
        ret.SetAnimTimeMsCurrent(GetAnimTimeMsCurrent());
        ret.SetAnimTimeMsTotal(GetAnimTimeMsTotal());
        ret.SetAttackType(GetAttackType());
        
        if(GetMmgColor() == null) {
            ret.SetMmgColor(GetMmgColor());
        } else {
            ret.SetMmgColor(GetMmgColor().Clone());            
        }
        
        if(GetCurrent() == null) {
            ret.SetCurrent(GetCurrent());
        } else {
            ret.SetCurrent(GetCurrent().Clone());
        }
        
        ret.SetDamage(GetDamage());
        ret.SetHeight(GetHeight());
        ret.SetHasParent(GetHasParent());
        ret.SetIsVisible(GetIsVisible());
        ret.SetId(GetId());
        ret.SetHolder(GetHolder());
        ret.SetParent(GetParent());

        if(GetPosition() == null) {
            ret.SetPosition(GetPosition());
        } else {
            ret.SetPosition(GetPosition().Clone());
        }
        
        if(subjBack == null) {
            ret.subjBack = subjBack;
        } else {
            ret.subjBack = subjBack.CloneTyped();
        }

        if(subjFront == null) {
            ret.subjFront = subjFront;
        } else {
            ret.subjFront = subjFront.CloneTyped();
        }

        if(subjLeft == null) {
            ret.subjLeft = subjLeft;
        } else {
            ret.subjLeft = subjLeft.CloneTyped();
        }

        if(subjRight == null) {
            ret.subjRight = subjRight;
        } else {
            ret.subjRight = subjRight.CloneTyped();
        }        
        
        ret.throwingDir = throwingDir;
        ret.throwingFrame = throwingFrame;
        ret.throwingPath = throwingPath;
        ret.throwingSpeed = throwingSpeed;
        ret.throwingSpeedSkew = throwingSpeedSkew;
        ret.throwingCoolDown = throwingCoolDown;
        ret.throwingTimeMsRotation = throwingTimeMsRotation;
        ret.throwingTimeMsCurrent = throwingTimeMsCurrent;
        ret.screen = screen;
        ret.stabbingCoolDown = stabbingCoolDown;
        return ret;
    }

    /*********************************************************
    ********* CHAPTER 8 CHALLENGE 2 SOLUTION PART 1 **********
    **********************************************************
    * Solution:
    * The first thing we need to do to solve this challenge is to bring
    * over some methods from the MdtWeaponAxe.java class. Due to the power
    * of polymorphism we can override the functionality of the super class
    * methods that control how to position the weapon. What this code does is
    * allows the weapon to have a position independent of the player wielding
    * it. This is required for throwable weapons.
    */
    
    /**
     * Gets the X coordinate.
     * 
     * @return      The X coordinate.
     */
    @Override
    public int GetX() {
        if(throwingFrame == 0) {
            return subjBack.GetX();
        } else if(throwingFrame == 1) {
            return subjFront.GetX();
        } else if(throwingFrame == 2) {
            return subjLeft.GetX();
        } else {
            return subjRight.GetX();                            
        }                          
    }
    
    /**
     * Gets the Y coordinate.
     * 
     * @return      The Y coordinate.
     */
    @Override
    public int GetY() {
        if(throwingFrame == 0) {
            return subjBack.GetY();
        } else if(throwingFrame == 1) {
            return subjFront.GetY();
        } else if(throwingFrame == 2) {
            return subjLeft.GetY();
        } else {
            return subjRight.GetY();                            
        }                            
    }  
    
    /**
     * Sets the position of the character.
     * 
     * @param v     The position to set.
     */
    @Override
    public void SetPosition(MmgVector2 v) {
        super.SetPosition(v);
        subjBack.SetPosition(v);
        subjFront.SetPosition(v);
        subjLeft.SetPosition(v);
        subjRight.SetPosition(v);
    }
    
    /**
     * Sets the position of the character.
     * 
     * @param x     The X coordinate to set.
     * @param y     The Y coordinate to set.
     */
    @Override
    public void SetPosition(int x, int y) {
        super.SetPosition(x, y);
        subjBack.SetPosition(x, y);
        subjFront.SetPosition(x, y);
        subjLeft.SetPosition(x, y);
        subjRight.SetPosition(x, y);
    }    
    
    /**
     * Sets the X coordinate position of the character.
     * 
     * @param i     The X coordinate to set.
     */
    @Override
    public void SetX(int i) {
        super.SetX(i);
        subjBack.SetX(i);
        subjFront.SetX(i);
        subjLeft.SetX(i);
        subjRight.SetX(i);
    }
    
    /**
     * Sets the Y coordinate position of the character.
     * 
     * @param i     The Y coordinate to set. 
     */
    @Override
    public void SetY(int i) {
        super.SetY(i);
        subjBack.SetY(i);
        subjFront.SetY(i);
        subjLeft.SetY(i);
        subjRight.SetY(i);
    }      
}