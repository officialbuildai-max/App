package com.bytedance.sdk.openadsdk.sP;

import com.bytedance.sdk.component.utils.Jcg;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public abstract class Sj {
    protected boolean Sj = false;
    private final ExecutorService sP = Executors.newSingleThreadExecutor();

    /* renamed from: com.bytedance.sdk.openadsdk.sP.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private class CallableC0295Sj implements Callable<Void> {
        private final File sP;

        private CallableC0295Sj(File file) {
            this.sP = file;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Sj, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            Sj.this.sP(this.sP);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(File file) throws IOException {
        if (!this.Sj) {
            try {
                Jcg.sP(file);
            } catch (Throwable unused) {
            }
            Sj(Jcg.Sj(file.getParentFile()));
        } else {
            List<File> Sj = Jcg.Sj(file);
            Sj.toString();
            Sj(Sj);
        }
    }

    public void Sj(File file) throws IOException {
        this.sP.submit(new CallableC0295Sj(file));
    }

    protected abstract void Sj(List<File> list);

    protected abstract boolean Sj(long j11, int i11);

    protected abstract boolean Sj(File file, long j11, int i11);

    /* JADX INFO: Access modifiers changed from: package-private */
    public long sP(List<File> list) {
        Iterator<File> it = list.iterator();
        long j11 = 0;
        while (it.hasNext()) {
            j11 += it.next().length();
        }
        return j11;
    }
}
