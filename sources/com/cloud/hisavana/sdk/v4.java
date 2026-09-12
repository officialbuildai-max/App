package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.b;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class v4 {

    /* renamed from: a, reason: collision with root package name */
    private f f23110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements b.InterfaceC0305b {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.b.InterfaceC0305b
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.a(taErrorCode, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.b.InterfaceC0305b
        public void b(List list, List list2, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.b(list2, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b implements r3 {
        b() {
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.a(taErrorCode, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void b(AdsDTO adsDTO, Bundle bundle) {
            e4.b().d("MaterialDownload", "loadPlatformAd onSuccess mAdBean ");
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(adsDTO);
            if (v4.this.f23110a != null) {
                v4.this.f23110a.b(arrayList, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class c implements r3 {
        c() {
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.a(taErrorCode, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void b(AdsDTO adsDTO, Bundle bundle) {
            e4.b().d("MaterialDownload", "loadPlatformAd onSuccess mAdBean ");
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(adsDTO);
            if (v4.this.f23110a != null) {
                v4.this.f23110a.b(arrayList, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class d implements r3 {
        d() {
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.a(taErrorCode, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void b(AdsDTO adsDTO, Bundle bundle) {
            e4.b().d("MaterialDownload", "loadPlatformAd onSuccess mAdBean ");
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(adsDTO);
            if (v4.this.f23110a != null) {
                v4.this.f23110a.b(arrayList, bundle);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class e implements r3 {
        e() {
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            if (v4.this.f23110a != null) {
                v4.this.f23110a.a(taErrorCode, bundle);
            }
        }

        @Override // com.cloud.hisavana.sdk.r3
        public void b(AdsDTO adsDTO, Bundle bundle) {
            e4.b().d("MaterialDownload", "loadPlatformAd onSuccess mAdBean ");
            ArrayList arrayList = new ArrayList(2);
            arrayList.add(adsDTO);
            if (v4.this.f23110a != null) {
                v4.this.f23110a.b(arrayList, bundle);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a(TaErrorCode taErrorCode, Bundle bundle);

        void b(List list, Bundle bundle);
    }

    private void b(AdsDTO adsDTO, int i11) {
        new m(adsDTO, i11, new b()).q();
    }

    private void d(List list) {
        e4.b().d("ssp", "start execute getAdCreativies.");
        new com.cloud.hisavana.sdk.b(list, 1, new a()).q();
    }

    private void f(AdsDTO adsDTO, int i11) {
        new n4(adsDTO, i11, new c()).q();
    }

    private void g(AdsDTO adsDTO, int i11) {
        new z1(adsDTO, i11, new e()).u();
    }

    private void h(AdsDTO adsDTO, int i11) {
        new q2(adsDTO, i11, new d()).r();
    }

    public void c(f fVar) {
        this.f23110a = fVar;
    }

    public void e(List list, int i11, int i12, int i13) {
        switch (i11) {
            case 1:
            case 6:
                if (i13 > 0) {
                    try {
                        if (list.size() > i13) {
                            e4.b().d("ssp", "ads dto subList -> " + i13);
                            list = list.subList(0, i13);
                        }
                    } catch (Throwable unused) {
                    }
                }
                d(list);
                return;
            case 2:
                b((AdsDTO) list.get(0), i12);
                return;
            case 3:
                f((AdsDTO) list.get(0), i12);
                return;
            case 4:
                h((AdsDTO) list.get(0), i12);
                return;
            case 5:
                g((AdsDTO) list.get(0), i12);
                return;
            case 7:
                g((AdsDTO) list.get(0), i12);
                return;
            default:
                return;
        }
    }
}
