package midireader.src.main;

public class Note {
    public final long tick;
    public final int channel;
    public final int note;
    public final boolean state;
    public final int velocity;

    public Note(long tick, int channel, int note, boolean state, int velocity) {
        this.tick = tick;
        this.channel = channel;
        this.note = note;
        this.state = state;
        this.velocity = velocity;
    }

    public String toString() {
        return "Tick: " + tick + " Channel: " + channel + " Note:  " + note + " On: " + state + " Velocity: " + velocity;
    }
}