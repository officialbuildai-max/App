package bw;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f17019a;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f17019a = new ThreadPoolExecutor(availableProcessors + 1, (availableProcessors * 2) + 1, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}
