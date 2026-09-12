package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.d0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List<c> events;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public SpliceScheduleCommand[] newArray(int i11) {
            return new SpliceScheduleCommand[i11];
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f25498a;

        /* renamed from: b, reason: collision with root package name */
        public final long f25499b;

        private b(int i11, long j11) {
            this.f25498a = i11;
            this.f25499b = j11;
        }

        /* synthetic */ b(int i11, long j11, a aVar) {
            this(i11, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b c(Parcel parcel) {
            return new b(parcel.readInt(), parcel.readLong());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d(Parcel parcel) {
            parcel.writeInt(this.f25498a);
            parcel.writeLong(this.f25499b);
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final long f25500a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f25501b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f25502c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f25503d;

        /* renamed from: e, reason: collision with root package name */
        public final long f25504e;

        /* renamed from: f, reason: collision with root package name */
        public final List f25505f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f25506g;

        /* renamed from: h, reason: collision with root package name */
        public final long f25507h;

        /* renamed from: i, reason: collision with root package name */
        public final int f25508i;

        /* renamed from: j, reason: collision with root package name */
        public final int f25509j;

        /* renamed from: k, reason: collision with root package name */
        public final int f25510k;

        private c(long j11, boolean z10, boolean z11, boolean z12, List list, long j12, boolean z13, long j13, int i11, int i12, int i13) {
            this.f25500a = j11;
            this.f25501b = z10;
            this.f25502c = z11;
            this.f25503d = z12;
            this.f25505f = Collections.unmodifiableList(list);
            this.f25504e = j12;
            this.f25506g = z13;
            this.f25507h = j13;
            this.f25508i = i11;
            this.f25509j = i12;
            this.f25510k = i13;
        }

        private c(Parcel parcel) {
            this.f25500a = parcel.readLong();
            this.f25501b = parcel.readByte() == 1;
            this.f25502c = parcel.readByte() == 1;
            this.f25503d = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i11 = 0; i11 < readInt; i11++) {
                arrayList.add(b.c(parcel));
            }
            this.f25505f = Collections.unmodifiableList(arrayList);
            this.f25504e = parcel.readLong();
            this.f25506g = parcel.readByte() == 1;
            this.f25507h = parcel.readLong();
            this.f25508i = parcel.readInt();
            this.f25509j = parcel.readInt();
            this.f25510k = parcel.readInt();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c d(Parcel parcel) {
            return new c(parcel);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c e(d0 d0Var) {
            ArrayList arrayList;
            boolean z10;
            long j11;
            boolean z11;
            long j12;
            int i11;
            int i12;
            int i13;
            boolean z12;
            boolean z13;
            long j13;
            long F = d0Var.F();
            boolean z14 = (d0Var.D() & 128) != 0;
            ArrayList arrayList2 = new ArrayList();
            if (z14) {
                arrayList = arrayList2;
                z10 = false;
                j11 = C.TIME_UNSET;
                z11 = false;
                j12 = C.TIME_UNSET;
                i11 = 0;
                i12 = 0;
                i13 = 0;
                z12 = false;
            } else {
                int D = d0Var.D();
                boolean z15 = (D & 128) != 0;
                boolean z16 = (D & 64) != 0;
                boolean z17 = (D & 32) != 0;
                long F2 = z16 ? d0Var.F() : C.TIME_UNSET;
                if (!z16) {
                    int D2 = d0Var.D();
                    ArrayList arrayList3 = new ArrayList(D2);
                    for (int i14 = 0; i14 < D2; i14++) {
                        arrayList3.add(new b(d0Var.D(), d0Var.F(), null));
                    }
                    arrayList2 = arrayList3;
                }
                if (z17) {
                    long D3 = d0Var.D();
                    boolean z18 = (128 & D3) != 0;
                    j13 = ((((D3 & 1) << 32) | d0Var.F()) * 1000) / 90;
                    z13 = z18;
                } else {
                    z13 = false;
                    j13 = C.TIME_UNSET;
                }
                int J = d0Var.J();
                int D4 = d0Var.D();
                z12 = z16;
                i13 = d0Var.D();
                j12 = j13;
                arrayList = arrayList2;
                long j14 = F2;
                i11 = J;
                i12 = D4;
                j11 = j14;
                boolean z19 = z15;
                z11 = z13;
                z10 = z19;
            }
            return new c(F, z14, z10, z12, arrayList, j11, z11, j12, i11, i12, i13);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(Parcel parcel) {
            parcel.writeLong(this.f25500a);
            parcel.writeByte(this.f25501b ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f25502c ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f25503d ? (byte) 1 : (byte) 0);
            int size = this.f25505f.size();
            parcel.writeInt(size);
            for (int i11 = 0; i11 < size; i11++) {
                ((b) this.f25505f.get(i11)).d(parcel);
            }
            parcel.writeLong(this.f25504e);
            parcel.writeByte(this.f25506g ? (byte) 1 : (byte) 0);
            parcel.writeLong(this.f25507h);
            parcel.writeInt(this.f25508i);
            parcel.writeInt(this.f25509j);
            parcel.writeInt(this.f25510k);
        }
    }

    private SpliceScheduleCommand(Parcel parcel) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i11 = 0; i11 < readInt; i11++) {
            arrayList.add(c.d(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    /* synthetic */ SpliceScheduleCommand(Parcel parcel, a aVar) {
        this(parcel);
    }

    private SpliceScheduleCommand(List<c> list) {
        this.events = Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SpliceScheduleCommand parseFromSection(d0 d0Var) {
        int D = d0Var.D();
        ArrayList arrayList = new ArrayList(D);
        for (int i11 = 0; i11 < D; i11++) {
            arrayList.add(c.e(d0Var));
        }
        return new SpliceScheduleCommand(arrayList);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i11) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i12 = 0; i12 < size; i12++) {
            this.events.get(i12).f(parcel);
        }
    }
}
