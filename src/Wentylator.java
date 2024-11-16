public class Wentylator {
    private boolean isWorking;
    private int coolingPowerPercentage;

    public int getCoolingPowerPercentage() {
        return coolingPowerPercentage;
    }

    public void setCoolingPowerPercentage(int coolingPowerPercentage) {
        this.coolingPowerPercentage = coolingPowerPercentage;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void setWorking(boolean working) {
        isWorking = working;
    }

    public void coolingControl(int temperature)
    {
        if(temperature < 50 || temperature > 130)
        {
            this.isWorking = false;
        }
        else
        {
            this.isWorking = true;
        }

        if(temperature >= 50 && temperature <= 75)
        {
            this.coolingPowerPercentage = 50;
        }

        if(temperature >=75 && temperature <= 130)
        {
            this.coolingPowerPercentage = 50;
        }
    }



}
