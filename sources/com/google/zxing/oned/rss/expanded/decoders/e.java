package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.NotFoundException;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ogg.DefaultOggSeeker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class e extends i {

    /* renamed from: c, reason: collision with root package name */
    private final String f32980c;

    /* renamed from: d, reason: collision with root package name */
    private final String f32981d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(id.a aVar, String str, String str2) {
        super(aVar);
        this.f32980c = str2;
        this.f32981d = str;
    }

    private void k(StringBuilder sb2, int i11) {
        int f11 = b().f(i11, 16);
        if (f11 == 38400) {
            return;
        }
        sb2.append('(');
        sb2.append(this.f32980c);
        sb2.append(')');
        int i12 = f11 % 32;
        int i13 = f11 / 32;
        int i14 = (i13 % 12) + 1;
        int i15 = i13 / 12;
        if (i15 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i15);
        if (i14 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i14);
        if (i12 / 10 == 0) {
            sb2.append('0');
        }
        sb2.append(i12);
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.j
    public String d() {
        if (c().m() != 84) {
            throw NotFoundException.getNotFoundInstance();
        }
        StringBuilder sb2 = new StringBuilder();
        f(sb2, 8);
        j(sb2, 48, 20);
        k(sb2, 68);
        return sb2.toString();
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected void h(StringBuilder sb2, int i11) {
        sb2.append('(');
        sb2.append(this.f32981d);
        sb2.append(i11 / DefaultOggSeeker.MATCH_BYTE_RANGE);
        sb2.append(')');
    }

    @Override // com.google.zxing.oned.rss.expanded.decoders.i
    protected int i(int i11) {
        return i11 % DefaultOggSeeker.MATCH_BYTE_RANGE;
    }
}
