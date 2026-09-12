package hf;

import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.tencent.tinker.android.dex.DexException;

/* loaded from: classes5.dex */
public final class c extends e {

    /* renamed from: b, reason: collision with root package name */
    private final jf.a f64553b;

    /* renamed from: c, reason: collision with root package name */
    private int f64554c;

    public c() {
        super(null);
        this.f64553b = new jf.a();
        this.f64554c = 0;
    }

    private void n(int i11) {
        int i12 = this.f64554c;
        if (i11 != i12) {
            this.f64553b.a(i11, i12);
        }
    }

    @Override // hf.e
    public void a(int i11, int i12, Object obj, int i13, int i14) {
        n(i11);
        int i15 = this.f64554c + 4;
        this.f64554c = i15;
        if (i14 == 1) {
            int length = ((byte[]) obj).length;
            this.f64554c = i15 + (length >> 1) + (length & 1);
            return;
        }
        if (i14 == 2) {
            this.f64554c = i15 + ((short[]) obj).length;
            return;
        }
        if (i14 == 4) {
            this.f64554c = i15 + (((int[]) obj).length * 2);
        } else {
            if (i14 == 8) {
                this.f64554c = i15 + (((long[]) obj).length * 4);
                return;
            }
            throw new DexException("bogus element_width: " + p008if.a.b(i14));
        }
    }

    @Override // hf.e
    public void b(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17, int i18, int i19, int i20) {
        n(i11);
        if (i12 != 36 && i12 != 252) {
            switch (i12) {
                case 110:
                case 111:
                case 112:
                case 113:
                case ASSET_WRITE_ERROR_VALUE:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
            }
        }
        this.f64554c += 3;
    }

    @Override // hf.e
    public void c(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17, int i18, int i19) {
        n(i11);
        if (i12 != 36) {
            switch (i12) {
                case 110:
                case 111:
                case 112:
                case 113:
                case ASSET_WRITE_ERROR_VALUE:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
            }
        }
        this.f64554c += 3;
    }

    @Override // hf.e
    public void d(int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (i12 == 250) {
            this.f64554c += 4;
            return;
        }
        throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
    }

    @Override // hf.e
    public void e(int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        if (i12 == 251) {
            this.f64554c += 4;
            return;
        }
        throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0023. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x0026. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0029. Please report as an issue. */
    @Override // hf.e
    public void f(int i11, int i12, int i13, int i14, int i15, long j11, int i16) {
        n(i11);
        if (i12 != 34) {
            if (i12 != 36 && i12 != 38) {
                if (i12 != 39) {
                    if (i12 != 43 && i12 != 44) {
                        if (i12 != 254 && i12 != 255) {
                            switch (i12) {
                                default:
                                    switch (i12) {
                                        case 15:
                                        case 16:
                                        case 17:
                                        case 18:
                                        case NOTIFICATION_REDIRECT_VALUE:
                                        case 30:
                                            break;
                                        case 19:
                                        case 21:
                                        case 22:
                                        case 25:
                                        case 28:
                                        case TEMPLATE_HTML_SIZE_VALUE:
                                            break;
                                        case 20:
                                        case 23:
                                            break;
                                        case 24:
                                            this.f64554c += 5;
                                            return;
                                        case 26:
                                            if (i13 > 65535) {
                                                this.f64554c += 3;
                                                return;
                                            } else {
                                                this.f64554c += 2;
                                                return;
                                            }
                                        case 27:
                                            this.f64554c += 3;
                                            return;
                                        default:
                                            switch (i12) {
                                                default:
                                                    switch (i12) {
                                                        case 96:
                                                        case 97:
                                                        case 98:
                                                        case 99:
                                                        case 100:
                                                        case 101:
                                                        case 102:
                                                        case 103:
                                                        case 104:
                                                        case 105:
                                                        case 106:
                                                        case 107:
                                                        case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                                                        case 109:
                                                            break;
                                                        case 110:
                                                        case 111:
                                                        case 112:
                                                        case 113:
                                                        case ASSET_WRITE_ERROR_VALUE:
                                                            break;
                                                        default:
                                                            throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
                                                    }
                                                case AD_VISIBILITY_VALUE:
                                                case 57:
                                                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                                                case 59:
                                                case 60:
                                                case 61:
                                                    this.f64554c += 2;
                                            }
                                    }
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                    this.f64554c++;
                                    return;
                            }
                        }
                    }
                }
                this.f64554c++;
                return;
            }
            this.f64554c += 3;
            return;
        }
        this.f64554c += 2;
    }

    @Override // hf.e
    public void g(int i11, int i12, int i13, int[] iArr) {
        n(i11);
        int i14 = this.f64554c + 4;
        this.f64554c = i14;
        this.f64554c = i14 + (iArr.length * 2);
    }

    @Override // hf.e
    public void h(int i11, int i12, int i13, int i14, int i15, long j11, int i16, int i17) {
        n(i11);
        if (i12 != 37 && i12 != 253) {
            switch (i12) {
                case GZIP_ENCODE_ERROR_VALUE:
                case ASSET_FAILED_STATUS_CODE_VALUE:
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                case JSON_ENCODE_ERROR_VALUE:
                case 120:
                    break;
                default:
                    throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
            }
        }
        this.f64554c += 3;
    }

    @Override // hf.e
    public void i(int i11, int i12, int[] iArr, int[] iArr2) {
        n(i11);
        int i13 = this.f64554c + 2;
        this.f64554c = i13;
        int length = i13 + (iArr.length * 2);
        this.f64554c = length;
        this.f64554c = length + (iArr2.length * 2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0007. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x000a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002e A[FALL_THROUGH] */
    @Override // hf.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void j(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9, int r10) {
        /*
            r0 = this;
            r0.n(r1)
            r1 = 36
            if (r2 == r1) goto L35
            switch(r2) {
                case 45: goto L2e;
                case 46: goto L2e;
                case 47: goto L2e;
                case 48: goto L2e;
                case 49: goto L2e;
                default: goto La;
            }
        La:
            switch(r2) {
                case 68: goto L2e;
                case 69: goto L2e;
                case 70: goto L2e;
                case 71: goto L2e;
                case 72: goto L2e;
                case 73: goto L2e;
                case 74: goto L2e;
                case 75: goto L2e;
                case 76: goto L2e;
                case 77: goto L2e;
                case 78: goto L2e;
                case 79: goto L2e;
                case 80: goto L2e;
                case 81: goto L2e;
                default: goto Ld;
            }
        Ld:
            switch(r2) {
                case 110: goto L35;
                case 111: goto L35;
                case 112: goto L35;
                case 113: goto L35;
                case 114: goto L35;
                default: goto L10;
            }
        L10:
            switch(r2) {
                case 144: goto L2e;
                case 145: goto L2e;
                case 146: goto L2e;
                case 147: goto L2e;
                case 148: goto L2e;
                case 149: goto L2e;
                case 150: goto L2e;
                case 151: goto L2e;
                case 152: goto L2e;
                case 153: goto L2e;
                case 154: goto L2e;
                case 155: goto L2e;
                case 156: goto L2e;
                case 157: goto L2e;
                case 158: goto L2e;
                case 159: goto L2e;
                case 160: goto L2e;
                case 161: goto L2e;
                case 162: goto L2e;
                case 163: goto L2e;
                case 164: goto L2e;
                case 165: goto L2e;
                case 166: goto L2e;
                case 167: goto L2e;
                case 168: goto L2e;
                case 169: goto L2e;
                case 170: goto L2e;
                case 171: goto L2e;
                case 172: goto L2e;
                case 173: goto L2e;
                case 174: goto L2e;
                case 175: goto L2e;
                default: goto L13;
            }
        L13:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected opcode: "
            r3.append(r4)
            java.lang.String r2 = p008if.a.c(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L2e:
            int r1 = r0.f64554c
            int r1 = r1 + 2
            r0.f64554c = r1
            goto L3b
        L35:
            int r1 = r0.f64554c
            int r1 = r1 + 3
            r0.f64554c = r1
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.c.j(int, int, int, int, int, long, int, int, int):void");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x0016. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0019. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x001c. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x001f. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x0013. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0055 A[FALL_THROUGH] */
    @Override // hf.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void k(int r1, int r2, int r3, int r4, int r5, long r6, int r8, int r9) {
        /*
            r0 = this;
            r0.n(r1)
            r1 = 32
            if (r2 == r1) goto L55
            r1 = 33
            if (r2 == r1) goto L4e
            r1 = 35
            if (r2 == r1) goto L55
            r1 = 36
            if (r2 == r1) goto L47
            switch(r2) {
                case 1: goto L4e;
                case 2: goto L40;
                case 3: goto L47;
                case 4: goto L4e;
                case 5: goto L40;
                case 6: goto L47;
                case 7: goto L4e;
                case 8: goto L40;
                case 9: goto L47;
                default: goto L16;
            }
        L16:
            switch(r2) {
                case 50: goto L55;
                case 51: goto L55;
                case 52: goto L55;
                case 53: goto L55;
                case 54: goto L55;
                case 55: goto L55;
                default: goto L19;
            }
        L19:
            switch(r2) {
                case 82: goto L55;
                case 83: goto L55;
                case 84: goto L55;
                case 85: goto L55;
                case 86: goto L55;
                case 87: goto L55;
                case 88: goto L55;
                case 89: goto L55;
                case 90: goto L55;
                case 91: goto L55;
                case 92: goto L55;
                case 93: goto L55;
                case 94: goto L55;
                case 95: goto L55;
                default: goto L1c;
            }
        L1c:
            switch(r2) {
                case 110: goto L47;
                case 111: goto L47;
                case 112: goto L47;
                case 113: goto L47;
                case 114: goto L47;
                default: goto L1f;
            }
        L1f:
            switch(r2) {
                case 123: goto L4e;
                case 124: goto L4e;
                case 125: goto L4e;
                case 126: goto L4e;
                case 127: goto L4e;
                case 128: goto L4e;
                case 129: goto L4e;
                case 130: goto L4e;
                case 131: goto L4e;
                case 132: goto L4e;
                case 133: goto L4e;
                case 134: goto L4e;
                case 135: goto L4e;
                case 136: goto L4e;
                case 137: goto L4e;
                case 138: goto L4e;
                case 139: goto L4e;
                case 140: goto L4e;
                case 141: goto L4e;
                case 142: goto L4e;
                case 143: goto L4e;
                default: goto L22;
            }
        L22:
            switch(r2) {
                case 176: goto L4e;
                case 177: goto L4e;
                case 178: goto L4e;
                case 179: goto L4e;
                case 180: goto L4e;
                case 181: goto L4e;
                case 182: goto L4e;
                case 183: goto L4e;
                case 184: goto L4e;
                case 185: goto L4e;
                case 186: goto L4e;
                case 187: goto L4e;
                case 188: goto L4e;
                case 189: goto L4e;
                case 190: goto L4e;
                case 191: goto L4e;
                case 192: goto L4e;
                case 193: goto L4e;
                case 194: goto L4e;
                case 195: goto L4e;
                case 196: goto L4e;
                case 197: goto L4e;
                case 198: goto L4e;
                case 199: goto L4e;
                case 200: goto L4e;
                case 201: goto L4e;
                case 202: goto L4e;
                case 203: goto L4e;
                case 204: goto L4e;
                case 205: goto L4e;
                case 206: goto L4e;
                case 207: goto L4e;
                case 208: goto L55;
                case 209: goto L55;
                case 210: goto L55;
                case 211: goto L55;
                case 212: goto L55;
                case 213: goto L55;
                case 214: goto L55;
                case 215: goto L55;
                case 216: goto L55;
                case 217: goto L55;
                case 218: goto L55;
                case 219: goto L55;
                case 220: goto L55;
                case 221: goto L55;
                case 222: goto L55;
                case 223: goto L55;
                case 224: goto L55;
                case 225: goto L55;
                case 226: goto L55;
                default: goto L25;
            }
        L25:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "unexpected opcode: "
            r3.append(r4)
            java.lang.String r2 = p008if.a.c(r2)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r1.<init>(r2)
            throw r1
        L40:
            int r1 = r0.f64554c
            int r1 = r1 + 2
            r0.f64554c = r1
            goto L5b
        L47:
            int r1 = r0.f64554c
            int r1 = r1 + 3
            r0.f64554c = r1
            goto L5b
        L4e:
            int r1 = r0.f64554c
            int r1 = r1 + 1
            r0.f64554c = r1
            goto L5b
        L55:
            int r1 = r0.f64554c
            int r1 = r1 + 2
            r0.f64554c = r1
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hf.c.k(int, int, int, int, int, long, int, int):void");
    }

    @Override // hf.e
    public void l(int i11, int i12, int i13, int i14, int i15, long j11) {
        n(i11);
        if (i12 == -1 || i12 == 0 || i12 == 14) {
            this.f64554c++;
            return;
        }
        if (i12 != 36) {
            switch (i12) {
                case 40:
                    int q11 = b.q(i15, this.f64554c);
                    if (q11 == ((byte) q11)) {
                        this.f64554c++;
                        return;
                    } else if (q11 != ((short) q11)) {
                        this.f64554c += 3;
                        return;
                    } else {
                        this.f64554c += 2;
                        return;
                    }
                case 41:
                    int q12 = b.q(i15, this.f64554c);
                    if (q12 != ((short) q12)) {
                        this.f64554c += 3;
                        return;
                    } else {
                        this.f64554c += 2;
                        return;
                    }
                case 42:
                    this.f64554c += 3;
                    return;
                default:
                    switch (i12) {
                        case 110:
                        case 111:
                        case 112:
                        case 113:
                        case ASSET_WRITE_ERROR_VALUE:
                            break;
                        default:
                            throw new IllegalStateException("unexpected opcode: " + p008if.a.c(i12));
                    }
            }
        }
        this.f64554c += 3;
    }

    public int m(int i11) {
        int k11 = this.f64553b.k(i11);
        return k11 < 0 ? i11 : this.f64553b.p(k11);
    }
}
