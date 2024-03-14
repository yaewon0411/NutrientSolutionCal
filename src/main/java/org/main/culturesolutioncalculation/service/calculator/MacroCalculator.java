package org.main.culturesolutioncalculation.service.calculator;

import javafx.scene.control.ToggleGroup;
import org.main.culturesolutioncalculation.DTO.macro.MacroNutrients;
import org.main.culturesolutioncalculation.DTO.users.Users;
import org.main.culturesolutioncalculation.SettingTabController;
import org.main.culturesolutioncalculation.service.database.DatabaseConnector;

import java.sql.Connection;
import java.sql.NClob;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Map;

public class MacroCalculator {

    private DatabaseConnector databaseConnector;
    private Connection connection;
    private boolean isConsidered;
    private SettingTabController settingTabController;
    private MacroNutrients macroNutrients;
    private Users users;


    public MacroCalculator(){
        this.connection = databaseConnector.getConnection();
        this.isConsidered = settingTabController.isConsidered();
    }

    public void loadInfo(boolean isConsidered) { //¿ø¼ö °í·Á À¯¹« ³Ñ¾î¿Í¾ß ÇÔ
//        if(!isConsidered) calculatedWithoutConsideredValue();
//        else calculateWithConsideredValue();

    }
    //¿ø¼ö °í·Á ¾øÀÌ °è»ê
    public void calculatedWithoutConsideredValue(Map<String, Double> fertilizer){ //´Ù·® ¿ø¼ö Ã³¹æ ³óµµ ³Ñ¾î¿Í¾ß ÇÔ
        //4¼ö¿° ³Ñ¾î¿À´ÂÁö 10¼ö¿° ³Ñ¾î¿À´ÂÁö
//        double Áú»êÄ®½·4¼ö¿° = 0.0, Áú»êÄ®½·10¼ö¿° = 0.0;
//        double Áú»êÄ®·ý, Áú»ê¾Ï¸ð´½, Á¦1ÀÎ»ê¾Ï¸ð´½, Á¦1ÀÎ»êÄ®·ý, È²»êÄ®·ý, È²»ê¸¶±×³×½·, È²»ê¾Ï¸ð´½,Áú»ê, È²»ê, ÀÎ»ê, ¿°È­Ä®·ý;
//        if(fertilizer.containsKey("Ca(NO3)2¡¤4H2O")){
//            /*
//
//
//             */
//        }else{
//
//        }


    }
    //¿ø¼ö °í·ÁÇÏ¿© °è»ê
    public void calculateWithConsideredValue(){

    }


    public void calculateMajor(double[] fertilizer, int majorSetting) {
        String[] compoundName = {
                "Áú»êÄ®½·4¼ö¿°\t",
                "Áú»êÄ®½·10¼ö¿°",
                "Áú»êÄ®·ý\t\t",
                "Áú»ê¾Ï¸ð´½\t",
                "Á¦1ÀÎ»ê¾Ï¸ð´½\t",
                "Á¦1ÀÎ»êÄ®·ý\t",
                "È²»êÄ®·ý \t",
                "È²»ê¸¶±×³×½·\t",
                "Áú»ê¸¶±×³×½·\t",
                "Áú»ê\t\t",
                "È²»ê\t\t",
                "ÀÎ»ê\t\t",
                "¿°È­Ä®·ý\t\t"
        };
        String[] majorSymbol={
                "NO3-N",
                "NH4-N",
                "H2PO4",
                "K\t",
                "Ca\t",
                "Mg\t",
                "SO4-S"
        };
        System.out.println("¦§-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦©");
        System.out.print("|\t\t\t");
        System.out.print("|\t");
        for(int i=0; i<7;i++){
            System.out.print(majorSymbol[i]+"\t|\t");
        }
        System.out.println();
        System.out.println("¦§-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦©");
        System.out.print("|½Ãºñ·®\t\t|");
        for (int i = 0; i < 7; i++) {
            System.out.print(fertilizer[i] + "\t\t|");
        }
        System.out.println();
        System.out.println("¦§-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦©");



        double[][] compounds = new double[13][7];
        compounds[0] = new double[]{0, 0, 0, 0, 0, 0, 0};   // Áú»êÄ®½· 4¼ö¿°
        compounds[1] = new double[]{0, 0, 0, 0, 0, 0, 0};   // Áú»êÄ®½· 10¼ö¿°
        compounds[2] = new double[]{1, 0, 0, 1, 0, 0, 0};   // Áú»êÄ®·ý
        compounds[3] = new double[]{1, 1, 0, 0, 0, 0, 0};   // Áú»ê¾Ï¸ð´½
        compounds[4] = new double[]{0, 1, 1, 0, 0, 0, 0};   // Á¦1ÀÎ»ê¾Ï¸ð´½
        compounds[5] = new double[]{0, 0, 0, 1, 1, 0, 0};   // Á¦1ÀÎ»êÄ®·ý
        compounds[6] = new double[]{0, 0, 0, 0, 2, 0, 1};   // È²»êÄ®·ý
        compounds[7] = new double[]{0, 0, 0, 0, 0, 1, 1};   // È²»ê¸¶±×³×½·
        compounds[8] = new double[]{2, 0, 0, 0, 0, 1, 0};   // Áú»ê¸¶±×³×½·
        compounds[9] = new double[]{1, 0, 0, 0, 0, 0, 0};   // Áú»ê
        compounds[10] = new double[]{0, 0, 0, 0, 0, 0, 1};  // È²»ê
        compounds[11] = new double[]{0, 0, 1, 0, 0, 0, 0};  // ÀÎ»ê
        compounds[12] = new double[]{0, 0, 0, 1, 0, 0, 0};  // ¿°È­Ä®·ý

        if (majorSetting == 0){
            compounds[0][0] = 2.0;
            compounds[0][4] = 1.0;
        } else if (majorSetting == 1) {
            compounds[1][0] = 2.2;
            compounds[1][1] = 0.2;
            compounds[1][4] = 1.0;
        }

        for(int i=0; i<13; i++) {
            double min = 1000000;
            if(Arrays.stream(fertilizer).sum()==0.0) min = 0.0;
            double[] compound = compounds[i];

            for (int j = 0; j < 7; j++) {
                if (compound[j] != 0 && fertilizer[j] / compound[j] < min) {
                    min = fertilizer[j] / compound[j];
                }
            }
            for (int j = 0; j < 7; j++) {
                min = Math.floor(min * 100) / 100.0;
                compound[j] *= min;
                fertilizer[j] -= compound[j];
            }
        }

        for (int i = 0; i < 13; i++) {
            System.out.print("|"+compoundName[i]+"|");
            for (int j = 0; j < 7; j++) {
                System.out.print(compounds[i][j] + "\t\t|");
            }
            System.out.println();
            System.out.println("¦§-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦©");
        }

        System.out.print("|½Ãºñ·®\t\t|");
        for (int i = 0; i < 7; i++) {
            double sum = 0;
            for(int j=0; j<13; j++){
                sum += compounds[j][i];
            }
            System.out.print(sum+"\t\t|");
        }
        System.out.println();
        System.out.println("¦§-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦«-----------¦©");
    }
}
