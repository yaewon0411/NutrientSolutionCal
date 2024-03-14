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

    public void loadInfo(boolean isConsidered) { //���� ��� ���� �Ѿ�;� ��
//        if(!isConsidered) calculatedWithoutConsideredValue();
//        else calculateWithConsideredValue();

    }
    //���� ��� ���� ���
    public void calculatedWithoutConsideredValue(Map<String, Double> fertilizer){ //�ٷ� ���� ó�� �� �Ѿ�;� ��
        //4���� �Ѿ������ 10���� �Ѿ������
//        double ����Į��4���� = 0.0, ����Į��10���� = 0.0;
//        double ����Į��, ����ϸ�, ��1�λ�ϸ�, ��1�λ�Į��, Ȳ��Į��, Ȳ�긶�׳׽�, Ȳ��ϸ�,����, Ȳ��, �λ�, ��ȭĮ��;
//        if(fertilizer.containsKey("Ca(NO3)2��4H2O")){
//            /*
//
//
//             */
//        }else{
//
//        }


    }
    //���� ����Ͽ� ���
    public void calculateWithConsideredValue(){

    }


    public void calculateMajor(double[] fertilizer, int majorSetting) {
        String[] compoundName = {
                "����Į��4����\t",
                "����Į��10����",
                "����Į��\t\t",
                "����ϸ�\t",
                "��1�λ�ϸ�\t",
                "��1�λ�Į��\t",
                "Ȳ��Į�� \t",
                "Ȳ�긶�׳׽�\t",
                "���긶�׳׽�\t",
                "����\t\t",
                "Ȳ��\t\t",
                "�λ�\t\t",
                "��ȭĮ��\t\t"
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
        System.out.println("��-----------��-----------��-----------��-----------��-----------��-----------��-----------��-----------��");
        System.out.print("|\t\t\t");
        System.out.print("|\t");
        for(int i=0; i<7;i++){
            System.out.print(majorSymbol[i]+"\t|\t");
        }
        System.out.println();
        System.out.println("��-----------��-----------��-----------��-----------��-----------��-----------��-----------��-----------��");
        System.out.print("|�ú�\t\t|");
        for (int i = 0; i < 7; i++) {
            System.out.print(fertilizer[i] + "\t\t|");
        }
        System.out.println();
        System.out.println("��-----------��-----------��-----------��-----------��-----------��-----------��-----------��-----------��");



        double[][] compounds = new double[13][7];
        compounds[0] = new double[]{0, 0, 0, 0, 0, 0, 0};   // ����Į�� 4����
        compounds[1] = new double[]{0, 0, 0, 0, 0, 0, 0};   // ����Į�� 10����
        compounds[2] = new double[]{1, 0, 0, 1, 0, 0, 0};   // ����Į��
        compounds[3] = new double[]{1, 1, 0, 0, 0, 0, 0};   // ����ϸ�
        compounds[4] = new double[]{0, 1, 1, 0, 0, 0, 0};   // ��1�λ�ϸ�
        compounds[5] = new double[]{0, 0, 0, 1, 1, 0, 0};   // ��1�λ�Į��
        compounds[6] = new double[]{0, 0, 0, 0, 2, 0, 1};   // Ȳ��Į��
        compounds[7] = new double[]{0, 0, 0, 0, 0, 1, 1};   // Ȳ�긶�׳׽�
        compounds[8] = new double[]{2, 0, 0, 0, 0, 1, 0};   // ���긶�׳׽�
        compounds[9] = new double[]{1, 0, 0, 0, 0, 0, 0};   // ����
        compounds[10] = new double[]{0, 0, 0, 0, 0, 0, 1};  // Ȳ��
        compounds[11] = new double[]{0, 0, 1, 0, 0, 0, 0};  // �λ�
        compounds[12] = new double[]{0, 0, 0, 1, 0, 0, 0};  // ��ȭĮ��

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
            System.out.println("��-----------��-----------��-----------��-----------��-----------��-----------��-----------��-----------��");
        }

        System.out.print("|�ú�\t\t|");
        for (int i = 0; i < 7; i++) {
            double sum = 0;
            for(int j=0; j<13; j++){
                sum += compounds[j][i];
            }
            System.out.print(sum+"\t\t|");
        }
        System.out.println();
        System.out.println("��-----------��-----------��-----------��-----------��-----------��-----------��-----------��-----------��");
    }
}
