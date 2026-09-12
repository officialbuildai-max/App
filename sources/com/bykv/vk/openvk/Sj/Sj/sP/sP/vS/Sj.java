package com.bykv.vk.openvk.Sj.Sj.sP.sP.vS;

import android.text.TextUtils;
import com.bykv.vk.openvk.Sj.Sj.Sj.TKC.TKC;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP;
import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
public abstract class Sj {

    /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.vS.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0198Sj extends Thread {
        final /* synthetic */ Sj Sj;
        private final Queue<a> EjP = new ArrayBlockingQueue(10);
        private Queue<a> sP = new LinkedBlockingQueue();
        private boolean TKC = true;
        private Queue<a> HiB = new LinkedBlockingQueue();

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.vS.Sj$Sj$a */
        /* loaded from: classes2.dex */
        public class a {

            /* renamed from: a, reason: collision with root package name */
            public int f20380a;

            /* renamed from: b, reason: collision with root package name */
            public String f20381b;

            /* renamed from: c, reason: collision with root package name */
            public String[] f20382c;

            /* renamed from: d, reason: collision with root package name */
            public int f20383d;

            /* renamed from: e, reason: collision with root package name */
            public String f20384e;

            /* renamed from: f, reason: collision with root package name */
            public TKC f20385f;

            public a() {
            }
        }

        public C0198Sj(Sj sj2) {
        }

        private a Sj(int i11, TKC tkc) {
            this.EjP.size();
            a poll = this.EjP.poll();
            if (poll == null) {
                poll = new a();
            }
            poll.f20380a = i11;
            poll.f20385f = tkc;
            return poll;
        }

        private void Sj() {
            while (true) {
                a poll = this.HiB.poll();
                if (poll == null) {
                    return;
                }
                poll.f20381b = poll.f20385f.Fmk();
                poll.f20382c = new String[]{poll.f20385f.Fmk()};
                int Sj = poll.f20385f.Sj();
                if (Sj <= 0) {
                    Sj = poll.f20385f.TKC();
                }
                poll.f20383d = Sj;
                poll.f20384e = poll.f20385f.sef();
                if (!TextUtils.isEmpty(poll.f20385f.sef())) {
                    poll.f20381b = poll.f20385f.sef();
                }
                poll.f20385f = null;
                TKC(poll);
            }
        }

        private void Sj(a aVar) {
            aVar.f20382c = null;
            aVar.f20381b = null;
            aVar.f20380a = -1;
            aVar.f20385f = null;
            this.EjP.offer(aVar);
        }

        private void TKC(a aVar) {
            if (aVar == null) {
                return;
            }
            this.sP.offer(aVar);
            notify();
        }

        private synchronized void sP(a aVar) {
            this.HiB.add(aVar);
            notify();
        }

        public void Sj(TKC tkc) {
            sP(Sj(0, tkc));
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.TKC) {
                synchronized (this) {
                    try {
                        if (!this.HiB.isEmpty()) {
                            Sj();
                        }
                        while (!this.sP.isEmpty()) {
                            a poll = this.sP.poll();
                            if (poll != null) {
                                int i11 = poll.f20380a;
                                if (i11 == 0) {
                                    String[] strArr = poll.f20382c;
                                    if (strArr != null && strArr.length > 0) {
                                        ArrayList arrayList = new ArrayList();
                                        for (String str : poll.f20382c) {
                                            if (f6.a.r(str)) {
                                                arrayList.add(str);
                                            }
                                        }
                                        EjP.j().h(false, !TextUtils.isEmpty(poll.f20384e), poll.f20383d, poll.f20381b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                                    }
                                } else if (i11 == 1) {
                                    EjP.j().e(poll.f20381b);
                                } else if (i11 == 2) {
                                    EjP.j().a();
                                } else if (i11 == 3) {
                                    EjP.j().a();
                                    com.bykv.vk.openvk.Sj.Sj.sP.sP.a.a();
                                    com.bykv.vk.openvk.Sj.Sj.sP.sP.a.b();
                                } else if (i11 == 4) {
                                    EjP.j().a();
                                    this.TKC = false;
                                }
                                Sj(poll);
                            }
                        }
                        try {
                            wait();
                        } catch (InterruptedException unused) {
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        }
    }
}
