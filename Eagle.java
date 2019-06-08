public class Eagle extends Bird implements Fly {

    private static final int _0 = 0;
	private boolean flying;
    private int altitude;

    public Eagle(String name) {
        super(name);
        this.flying = false;
        this.altitude = 0;
    }

    public int getAltitude() {
        return altitude;
    }

    public boolean isFlying() {
        return flying;
    }

    @Override
    public String sing() {
        return "Screech!";
    }

    @Override
    public void takeOff() {
        if (!this.flying && this.altitude == 0) {
            this.flying = true;
            System.out.printf("%s takes off in the sky.%n", this.getName());
        }
    }

    /**
     * swim downward
     * @param meters altitude increase
     * @return depth
     */
    @Override
    public int descend(int meters) {
        if (this.flying) {
            this.altitude = Math.min(this.altitude - meters, 325);
            System.out.printf("%s flies downward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * swin upward
     * @param meters altitude decrease
     * @return depth
     */
    @Override
    public int ascend(int meters) {
        if (this.flying) {
            this.altitude = Math.max(this.altitude + meters, 0);
            System.out.printf("%s flies upward, altitude : %d%n", this.getName(), this.altitude);
        }
        return this.altitude;
    }

    /**
     * get out of water, must be on surface
     */
    @Override
    public void land() {
        if (this.flying && this.altitude == 1) {
            System.out.printf("%s land on the ground. %n", this.getName());
        } else {
            System.out.printf("%s is too high, it can't lands. %n", this.getName());
        }
    }


}
