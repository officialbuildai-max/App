package com.amazonaws.util;

/* loaded from: classes2.dex */
final class TimingInfoUnmodifiable extends TimingInfo {
    /* JADX INFO: Access modifiers changed from: package-private */
    public TimingInfoUnmodifiable(Long l11, long j11, Long l12) {
        super(l11, j11, l12);
    }

    @Override // com.amazonaws.util.TimingInfo
    public TimingInfo c() {
        throw new UnsupportedOperationException();
    }
}
