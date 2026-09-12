package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.cloud.tmc.integration.audio.recording.RecorderConstants;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ExtractorInput;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.IOException;

/* loaded from: classes5.dex */
final class Sniffer {
    private static final int[] COMPATIBLE_BRANDS = {Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("iso3"), Util.getIntegerCodeForString("iso4"), Util.getIntegerCodeForString("iso5"), Util.getIntegerCodeForString("iso6"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV")};
    private static final int SEARCH_LENGTH = 4096;

    private Sniffer() {
    }

    private static boolean isCompatibleBrand(int i11) {
        if ((i11 >>> 8) == Util.getIntegerCodeForString(RecorderConstants.FORMAT_3GP)) {
            return true;
        }
        for (int i12 : COMPATIBLE_BRANDS) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static boolean sniffFragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, true);
    }

    private static boolean sniffInternal(ExtractorInput extractorInput, boolean z10) throws IOException, InterruptedException {
        boolean z11;
        boolean z12;
        int i11;
        long length = extractorInput.getLength();
        long j11 = -1;
        if (length == -1 || length > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        int i12 = (int) length;
        ParsableByteArray parsableByteArray = new ParsableByteArray(64);
        int i13 = 0;
        boolean z13 = false;
        while (i13 < i12) {
            parsableByteArray.reset(8);
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            long readUnsignedInt = parsableByteArray.readUnsignedInt();
            int readInt = parsableByteArray.readInt();
            if (readUnsignedInt == 1) {
                extractorInput.peekFully(parsableByteArray.data, 8, 8);
                parsableByteArray.setLimit(16);
                i11 = 16;
                readUnsignedInt = parsableByteArray.readUnsignedLongToLong();
            } else {
                if (readUnsignedInt == 0) {
                    long length2 = extractorInput.getLength();
                    if (length2 != j11) {
                        readUnsignedInt = 8 + (length2 - extractorInput.getPosition());
                    }
                }
                i11 = 8;
            }
            long j12 = i11;
            if (readUnsignedInt < j12) {
                return false;
            }
            i13 += i11;
            if (readInt != Atom.TYPE_moov) {
                if (readInt == Atom.TYPE_moof || readInt == Atom.TYPE_mvex) {
                    z11 = true;
                    z12 = true;
                    break;
                }
                if ((i13 + readUnsignedInt) - j12 >= i12) {
                    break;
                }
                int i14 = (int) (readUnsignedInt - j12);
                i13 += i14;
                if (readInt == Atom.TYPE_ftyp) {
                    if (i14 < 8) {
                        return false;
                    }
                    parsableByteArray.reset(i14);
                    extractorInput.peekFully(parsableByteArray.data, 0, i14);
                    int i15 = i14 / 4;
                    int i16 = 0;
                    while (true) {
                        if (i16 >= i15) {
                            break;
                        }
                        if (i16 == 1) {
                            parsableByteArray.skipBytes(4);
                        } else if (isCompatibleBrand(parsableByteArray.readInt())) {
                            z13 = true;
                            break;
                        }
                        i16++;
                    }
                    if (!z13) {
                        return false;
                    }
                } else if (i14 != 0) {
                    extractorInput.advancePeekPosition(i14);
                }
                j11 = -1;
            }
        }
        z11 = true;
        z12 = false;
        if (z13 && z10 == z12) {
            return z11;
        }
        return false;
    }

    public static boolean sniffUnfragmented(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return sniffInternal(extractorInput, false);
    }
}
