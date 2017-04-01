package midireader.src.main;

public class Reader {
    public static final String songPath = "C:\\Users\\Clyde\\Documents\\test.mid";

    public static void main(String[] args) throws Exception {
        Sequence sequence = MidiSystem.getSequence(new File(songPath));

        int trackNumber = 0;
        for (Track track :  sequence.getTracks()) {
            trackNumber++;
            System.out.println("Track " + trackNumber + ": size = " + track.size());
            System.out.println();
            for (int i=0; i < track.size(); i++) {
                MidiEvent event = track.get(i);
                MidiMessage message = event.getMessage();
                if (message instanceof ShortMessage) {
                    ShortMessage sm = (ShortMessage) message;
                    if (sm.getCommand() == 0x90) {
                        //log a note's tick, channel, note number, state, and velocity
                        Note n = new Note(event.getTick(), sm.getChannel(), sm.getData1(), true, sm.getData2());
                    } else if (sm.getCommand() == 0x80) {
                        Note n = new Note(event.getTick(), sm.getChannel(), sm.getData1(), false, sm.getData2());
                    } else {
                        System.out.println("Command:" + sm.getCommand());
                    }
                } else {
                    System.out.println("Other message: " + message.getClass());
                }
            }
            System.out.println();
        }
    }
}