package g9;

/* loaded from: classes4.dex */
public abstract class w implements m {

    /* renamed from: a, reason: collision with root package name */
    private final m f63596a;

    public w(m mVar) {
        this.f63596a = mVar;
    }

    @Override // g9.m
    public void advancePeekPosition(int i11) {
        this.f63596a.advancePeekPosition(i11);
    }

    @Override // g9.m
    public boolean advancePeekPosition(int i11, boolean z10) {
        return this.f63596a.advancePeekPosition(i11, z10);
    }

    @Override // g9.m
    public int b(byte[] bArr, int i11, int i12) {
        return this.f63596a.b(bArr, i11, i12);
    }

    @Override // g9.m
    public long getLength() {
        return this.f63596a.getLength();
    }

    @Override // g9.m
    public long getPeekPosition() {
        return this.f63596a.getPeekPosition();
    }

    @Override // g9.m
    public long getPosition() {
        return this.f63596a.getPosition();
    }

    @Override // g9.m
    public void peekFully(byte[] bArr, int i11, int i12) {
        this.f63596a.peekFully(bArr, i11, i12);
    }

    @Override // g9.m
    public boolean peekFully(byte[] bArr, int i11, int i12, boolean z10) {
        return this.f63596a.peekFully(bArr, i11, i12, z10);
    }

    @Override // g9.m, com.google.android.exoplayer2.upstream.g
    public int read(byte[] bArr, int i11, int i12) {
        return this.f63596a.read(bArr, i11, i12);
    }

    @Override // g9.m
    public void readFully(byte[] bArr, int i11, int i12) {
        this.f63596a.readFully(bArr, i11, i12);
    }

    @Override // g9.m
    public boolean readFully(byte[] bArr, int i11, int i12, boolean z10) {
        return this.f63596a.readFully(bArr, i11, i12, z10);
    }

    @Override // g9.m
    public void resetPeekPosition() {
        this.f63596a.resetPeekPosition();
    }

    @Override // g9.m
    public int skip(int i11) {
        return this.f63596a.skip(i11);
    }

    @Override // g9.m
    public void skipFully(int i11) {
        this.f63596a.skipFully(i11);
    }
}
