package org.main.culturesolutioncalculation.DTO.macro;

//설정 탭에서 선택한 질산 칼슘 비료 두 값중 하나
public class MacroNutrients {

    private boolean CalciumNitrate_4;
    private boolean CalciumNitrate_10;

    public boolean isCalciumNitrate_4() {
        return CalciumNitrate_4;
    }

    public boolean isCalciumNitrate_10() {
        return CalciumNitrate_10;
    }
}
