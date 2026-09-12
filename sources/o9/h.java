package o9;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.InternalFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.s;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.x;

/* loaded from: classes4.dex */
abstract class h {

    /* renamed from: a, reason: collision with root package name */
    static final String[] f70956a = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Afro-Punk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop", "Abstract", "Art Rock", "Baroque", "Bhangra", "Big beat", "Breakbeat", "Chillout", "Downtempo", "Dub", "EBM", "Eclectic", "Electro", "Electroclash", "Emo", "Experimental", "Garage", "Global", "IDM", "Illbient", "Industro-Goth", "Jam Band", "Krautrock", "Leftfield", "Lounge", "Math Rock", "New Romantic", "Nu-Breakz", "Post-Punk", "Post-Rock", "Psytrance", "Shoegaze", "Space Rock", "Trop Rock", "World Music", "Neoclassical", "Audiobook", "Audio theatre", "Neue Deutsche Welle", "Podcast", "Indie-Rock", "G-Funk", "Dubstep", "Garage Rock", "Psybient"};

    private static CommentFrame a(int i11, d0 d0Var) {
        int n11 = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            String y10 = d0Var.y(n11 - 16);
            return new CommentFrame(C.LANGUAGE_UNDETERMINED, y10, y10);
        }
        s.i("MetadataUtil", "Failed to parse comment attribute: " + a.a(i11));
        return null;
    }

    private static ApicFrame b(d0 d0Var) {
        int n11 = d0Var.n();
        if (d0Var.n() != 1684108385) {
            s.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int b11 = a.b(d0Var.n());
        String str = b11 == 13 ? "image/jpeg" : b11 == 14 ? "image/png" : null;
        if (str == null) {
            s.i("MetadataUtil", "Unrecognized cover art flags: " + b11);
            return null;
        }
        d0Var.Q(4);
        int i11 = n11 - 16;
        byte[] bArr = new byte[i11];
        d0Var.j(bArr, 0, i11);
        return new ApicFrame(str, null, 3, bArr);
    }

    public static Metadata.Entry c(d0 d0Var) {
        int e11 = d0Var.e() + d0Var.n();
        int n11 = d0Var.n();
        int i11 = (n11 >> 24) & 255;
        try {
            if (i11 == 169 || i11 == 253) {
                int i12 = 16777215 & n11;
                if (i12 == 6516084) {
                    return a(n11, d0Var);
                }
                if (i12 == 7233901 || i12 == 7631467) {
                    return h(n11, "TIT2", d0Var);
                }
                if (i12 == 6516589 || i12 == 7828084) {
                    return h(n11, "TCOM", d0Var);
                }
                if (i12 == 6578553) {
                    return h(n11, "TDRC", d0Var);
                }
                if (i12 == 4280916) {
                    return h(n11, "TPE1", d0Var);
                }
                if (i12 == 7630703) {
                    return h(n11, "TSSE", d0Var);
                }
                if (i12 == 6384738) {
                    return h(n11, "TALB", d0Var);
                }
                if (i12 == 7108978) {
                    return h(n11, "USLT", d0Var);
                }
                if (i12 == 6776174) {
                    return h(n11, "TCON", d0Var);
                }
                if (i12 == 6779504) {
                    return h(n11, "TIT1", d0Var);
                }
            } else {
                if (n11 == 1735291493) {
                    return g(d0Var);
                }
                if (n11 == 1684632427) {
                    return d(n11, "TPOS", d0Var);
                }
                if (n11 == 1953655662) {
                    return d(n11, "TRCK", d0Var);
                }
                if (n11 == 1953329263) {
                    return i(n11, "TBPM", d0Var, true, false);
                }
                if (n11 == 1668311404) {
                    return i(n11, "TCMP", d0Var, true, true);
                }
                if (n11 == 1668249202) {
                    return b(d0Var);
                }
                if (n11 == 1631670868) {
                    return h(n11, "TPE2", d0Var);
                }
                if (n11 == 1936682605) {
                    return h(n11, "TSOT", d0Var);
                }
                if (n11 == 1936679276) {
                    return h(n11, "TSO2", d0Var);
                }
                if (n11 == 1936679282) {
                    return h(n11, "TSOA", d0Var);
                }
                if (n11 == 1936679265) {
                    return h(n11, "TSOP", d0Var);
                }
                if (n11 == 1936679791) {
                    return h(n11, "TSOC", d0Var);
                }
                if (n11 == 1920233063) {
                    return i(n11, "ITUNESADVISORY", d0Var, false, false);
                }
                if (n11 == 1885823344) {
                    return i(n11, "ITUNESGAPLESS", d0Var, false, true);
                }
                if (n11 == 1936683886) {
                    return h(n11, "TVSHOWSORT", d0Var);
                }
                if (n11 == 1953919848) {
                    return h(n11, "TVSHOW", d0Var);
                }
                if (n11 == 757935405) {
                    return e(d0Var, e11);
                }
            }
            s.b("MetadataUtil", "Skipped unknown metadata entry: " + a.a(n11));
            d0Var.P(e11);
            return null;
        } finally {
            d0Var.P(e11);
        }
    }

    private static TextInformationFrame d(int i11, String str, d0 d0Var) {
        int n11 = d0Var.n();
        if (d0Var.n() == 1684108385 && n11 >= 22) {
            d0Var.Q(10);
            int J = d0Var.J();
            if (J > 0) {
                String str2 = "" + J;
                int J2 = d0Var.J();
                if (J2 > 0) {
                    str2 = str2 + "/" + J2;
                }
                return new TextInformationFrame(str, null, str2);
            }
        }
        s.i("MetadataUtil", "Failed to parse index/count attribute: " + a.a(i11));
        return null;
    }

    private static Id3Frame e(d0 d0Var, int i11) {
        String str = null;
        String str2 = null;
        int i12 = -1;
        int i13 = -1;
        while (d0Var.e() < i11) {
            int e11 = d0Var.e();
            int n11 = d0Var.n();
            int n12 = d0Var.n();
            d0Var.Q(4);
            if (n12 == 1835360622) {
                str = d0Var.y(n11 - 12);
            } else if (n12 == 1851878757) {
                str2 = d0Var.y(n11 - 12);
            } else {
                if (n12 == 1684108385) {
                    i12 = e11;
                    i13 = n11;
                }
                d0Var.Q(n11 - 12);
            }
        }
        if (str == null || str2 == null || i12 == -1) {
            return null;
        }
        d0Var.P(i12);
        d0Var.Q(16);
        return new InternalFrame(str, str2, d0Var.y(i13 - 16));
    }

    public static MdtaMetadataEntry f(d0 d0Var, int i11, String str) {
        while (true) {
            int e11 = d0Var.e();
            if (e11 >= i11) {
                return null;
            }
            int n11 = d0Var.n();
            if (d0Var.n() == 1684108385) {
                int n12 = d0Var.n();
                int n13 = d0Var.n();
                int i12 = n11 - 16;
                byte[] bArr = new byte[i12];
                d0Var.j(bArr, 0, i12);
                return new MdtaMetadataEntry(str, bArr, n13, n12);
            }
            d0Var.P(e11 + n11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.exoplayer2.metadata.id3.TextInformationFrame g(com.google.android.exoplayer2.util.d0 r3) {
        /*
            int r3 = j(r3)
            r0 = 0
            if (r3 <= 0) goto L11
            java.lang.String[] r1 = o9.h.f70956a
            int r2 = r1.length
            if (r3 > r2) goto L11
            int r3 = r3 + (-1)
            r3 = r1[r3]
            goto L12
        L11:
            r3 = r0
        L12:
            if (r3 == 0) goto L1c
            com.google.android.exoplayer2.metadata.id3.TextInformationFrame r1 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame
            java.lang.String r2 = "TCON"
            r1.<init>(r2, r0, r3)
            return r1
        L1c:
            java.lang.String r3 = "MetadataUtil"
            java.lang.String r1 = "Failed to parse standard genre code"
            com.google.android.exoplayer2.util.s.i(r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.h.g(com.google.android.exoplayer2.util.d0):com.google.android.exoplayer2.metadata.id3.TextInformationFrame");
    }

    private static TextInformationFrame h(int i11, String str, d0 d0Var) {
        int n11 = d0Var.n();
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return new TextInformationFrame(str, null, d0Var.y(n11 - 16));
        }
        s.i("MetadataUtil", "Failed to parse text attribute: " + a.a(i11));
        return null;
    }

    private static Id3Frame i(int i11, String str, d0 d0Var, boolean z10, boolean z11) {
        int j11 = j(d0Var);
        if (z11) {
            j11 = Math.min(1, j11);
        }
        if (j11 >= 0) {
            return z10 ? new TextInformationFrame(str, null, Integer.toString(j11)) : new CommentFrame(C.LANGUAGE_UNDETERMINED, str, Integer.toString(j11));
        }
        s.i("MetadataUtil", "Failed to parse uint8 attribute: " + a.a(i11));
        return null;
    }

    private static int j(d0 d0Var) {
        d0Var.Q(4);
        if (d0Var.n() == 1684108385) {
            d0Var.Q(8);
            return d0Var.D();
        }
        s.i("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    public static void k(int i11, x xVar, o1.b bVar) {
        if (i11 == 1 && xVar.a()) {
            bVar.N(xVar.f63598a).O(xVar.f63599b);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:3:0x000b, code lost:
    
        if (r6 != null) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void l(int r5, com.google.android.exoplayer2.metadata.Metadata r6, com.google.android.exoplayer2.metadata.Metadata r7, com.google.android.exoplayer2.o1.b r8, com.google.android.exoplayer2.metadata.Metadata... r9) {
        /*
            com.google.android.exoplayer2.metadata.Metadata r0 = new com.google.android.exoplayer2.metadata.Metadata
            r1 = 0
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r2 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r1]
            r0.<init>(r2)
            r2 = 1
            if (r5 != r2) goto Le
            if (r6 == 0) goto L3b
            goto L3c
        Le:
            r6 = 2
            if (r5 != r6) goto L3b
            if (r7 == 0) goto L3b
            r5 = r1
        L14:
            int r6 = r7.length()
            if (r5 >= r6) goto L3b
            com.google.android.exoplayer2.metadata.Metadata$Entry r6 = r7.get(r5)
            boolean r3 = r6 instanceof com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry r6 = (com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry) r6
            java.lang.String r3 = r6.key
            java.lang.String r4 = "com.android.capture.fps"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L39
            com.google.android.exoplayer2.metadata.Metadata r5 = new com.google.android.exoplayer2.metadata.Metadata
            com.google.android.exoplayer2.metadata.Metadata$Entry[] r7 = new com.google.android.exoplayer2.metadata.Metadata.Entry[r2]
            r7[r1] = r6
            r5.<init>(r7)
            r6 = r5
            goto L3c
        L39:
            int r5 = r5 + r2
            goto L14
        L3b:
            r6 = r0
        L3c:
            int r5 = r9.length
        L3d:
            if (r1 >= r5) goto L47
            r7 = r9[r1]
            com.google.android.exoplayer2.metadata.Metadata r6 = r6.copyWithAppendedEntriesFrom(r7)
            int r1 = r1 + r2
            goto L3d
        L47:
            int r5 = r6.length()
            if (r5 <= 0) goto L50
            r8.X(r6)
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o9.h.l(int, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.metadata.Metadata, com.google.android.exoplayer2.o1$b, com.google.android.exoplayer2.metadata.Metadata[]):void");
    }
}
