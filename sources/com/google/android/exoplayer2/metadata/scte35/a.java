package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.d;
import com.google.android.exoplayer2.metadata.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class a extends g {

    /* renamed from: a, reason: collision with root package name */
    private final d0 f25511a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private final c0 f25512b = new c0();

    /* renamed from: c, reason: collision with root package name */
    private l0 f25513c;

    @Override // com.google.android.exoplayer2.metadata.g
    protected Metadata b(d dVar, ByteBuffer byteBuffer) {
        l0 l0Var = this.f25513c;
        if (l0Var == null || dVar.f25472i != l0Var.e()) {
            l0 l0Var2 = new l0(dVar.f24899e);
            this.f25513c = l0Var2;
            l0Var2.a(dVar.f24899e - dVar.f25472i);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f25511a.N(array, limit);
        this.f25512b.o(array, limit);
        this.f25512b.r(39);
        long h11 = (this.f25512b.h(1) << 32) | this.f25512b.h(32);
        this.f25512b.r(20);
        int h12 = this.f25512b.h(12);
        int h13 = this.f25512b.h(8);
        this.f25511a.Q(14);
        Metadata.Entry parseFromSection = h13 != 0 ? h13 != 255 ? h13 != 4 ? h13 != 5 ? h13 != 6 ? null : TimeSignalCommand.parseFromSection(this.f25511a, h11, this.f25513c) : SpliceInsertCommand.parseFromSection(this.f25511a, h11, this.f25513c) : SpliceScheduleCommand.parseFromSection(this.f25511a) : PrivateCommand.parseFromSection(this.f25511a, h12, h11) : new SpliceNullCommand();
        return parseFromSection == null ? new Metadata(new Metadata.Entry[0]) : new Metadata(parseFromSection);
    }
}
