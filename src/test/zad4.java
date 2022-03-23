package test;

public class zad4 {

    public static class Kraslaw {
        private String text;
        private long[] crc_Table;

        public Kraslaw(String text) {
            crc_Table = new long[256];
            this.text = text;
        }

        void prepareCrcTable() {
            for (int i = 0; i < 256; i++) {
                long code = i;
                for (int j = 0; j < 8; j++) {
                    if ((code & 0x01) > 0) {
                        final long LONG_MASK = 0xffffffffL;
                        code = (0xEDB88320 & LONG_MASK) ^ (code >>> 1);
                    }
                    else {
                        code = code >>> 1;
                    }
                }
                crc_Table[i] = code;
            }
        }

        long crc32() {
            long crc = -1;
            for (int i = 0; i < text.length(); i++) {
                final long code = Character.codePointAt(text, i);
                crc = crc_Table[(int) ((code ^ crc) & 0xff)] ^ (crc >>> 8);
            }
            return (1 ^ crc) >>> 0;
        }

        public static void main(String[] args) {
            Kraslaw kraslaw = new Kraslaw("This is example text ...");
            kraslaw.prepareCrcTable();
            System.out.println(kraslaw.crc32());
        }
    }
}