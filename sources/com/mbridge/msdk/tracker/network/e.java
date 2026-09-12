package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;

/* loaded from: classes5.dex */
public class e implements x {

    /* renamed from: a, reason: collision with root package name */
    private int f38620a;

    /* renamed from: b, reason: collision with root package name */
    private long f38621b;

    /* renamed from: c, reason: collision with root package name */
    private int f38622c;

    /* renamed from: d, reason: collision with root package name */
    private final int f38623d;

    public e() {
        this(DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS, 1);
    }

    public e(int i11, int i12) {
        this(i11, 60000L, i12);
    }

    public e(int i11, long j11, int i12) {
        this.f38621b = j11;
        this.f38620a = i11;
        this.f38623d = i12;
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public long a() {
        return this.f38621b;
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public boolean a(b0 b0Var) {
        int i11 = this.f38622c + 1;
        this.f38622c = i11;
        return i11 <= this.f38623d;
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public int b() {
        return this.f38620a;
    }

    @Override // com.mbridge.msdk.tracker.network.x
    public int c() {
        return this.f38622c;
    }
}
