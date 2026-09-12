package retrofit2;

import okhttp3.Request;

/* loaded from: classes7.dex */
public interface d<T> extends Cloneable {
    void cancel();

    /* renamed from: clone */
    d mo1363clone();

    j0 execute();

    void h(f fVar);

    boolean isCanceled();

    Request request();
}
