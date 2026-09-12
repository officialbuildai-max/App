package com.squareup.okhttp.internal.framed;

import java.io.IOException;
import java.util.List;
import okio.BufferedSource;

/* loaded from: classes5.dex */
public interface PushObserver {
    public static final PushObserver CANCEL = new a();

    /* loaded from: classes5.dex */
    static class a implements PushObserver {
        a() {
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z10) {
            bufferedSource.skip(i12);
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean onHeaders(int i11, List list, boolean z10) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public boolean onRequest(int i11, List list) {
            return true;
        }

        @Override // com.squareup.okhttp.internal.framed.PushObserver
        public void onReset(int i11, ErrorCode errorCode) {
        }
    }

    boolean onData(int i11, BufferedSource bufferedSource, int i12, boolean z10) throws IOException;

    boolean onHeaders(int i11, List<b> list, boolean z10);

    boolean onRequest(int i11, List<b> list);

    void onReset(int i11, ErrorCode errorCode);
}
