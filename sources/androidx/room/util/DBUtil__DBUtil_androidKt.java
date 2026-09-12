package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.k0;
import androidx.room.z;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class DBUtil__DBUtil_androidKt {
    public static final void a(a4.d db2) {
        Intrinsics.h(db2, "db");
        b.b(new androidx.room.driver.a(db2));
    }

    public static final Object b(RoomDatabase roomDatabase, boolean z10, Continuation continuation) {
        ContinuationInterceptor c11;
        CoroutineContext plus;
        if (!roomDatabase.K()) {
            return roomDatabase.x().getCoroutineContext();
        }
        k0 k0Var = (k0) continuation.getContext().get(k0.f14788c);
        return (k0Var == null || (c11 = k0Var.c()) == null || (plus = roomDatabase.A().plus(c11)) == null) ? z10 ? roomDatabase.H() : roomDatabase.A() : plus;
    }

    public static final Object c(RoomDatabase db2, boolean z10, boolean z11, Function1 block) {
        Intrinsics.h(db2, "db");
        Intrinsics.h(block, "block");
        db2.i();
        db2.j();
        return RunBlockingUninterruptible_androidKt.a(new DBUtil__DBUtil_androidKt$performBlocking$1(db2, z11, z10, block, null));
    }

    public static final Object d(RoomDatabase roomDatabase, Function1 function1, Continuation continuation) {
        return roomDatabase.K() ? z.d(roomDatabase, new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(roomDatabase, function1, null), continuation) : kotlinx.coroutines.i.g(roomDatabase.x().getCoroutineContext(), new DBUtil__DBUtil_androidKt$performInTransactionSuspending$3(roomDatabase, function1, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b2 A[PHI: r0
      0x00b2: PHI (r0v9 java.lang.Object) = (r0v8 java.lang.Object), (r0v12 java.lang.Object), (r0v1 java.lang.Object) binds: [B:28:0x0080, B:17:0x00af, B:20:0x0052] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(androidx.room.RoomDatabase r16, boolean r17, boolean r18, kotlin.jvm.functions.Function1 r19, kotlin.coroutines.Continuation r20) {
        /*
            r6 = r16
            r7 = r17
            r1 = r18
            r0 = r20
            boolean r2 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            if (r2 == 0) goto L1c
            r2 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r2 = (androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L1c
            int r3 = r3 - r4
            r2.label = r3
        L1a:
            r8 = r2
            goto L22
        L1c:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r2 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r2.<init>(r0)
            goto L1a
        L22:
            java.lang.Object r0 = r8.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r8.label
            r3 = 3
            r4 = 2
            r10 = 1
            if (r2 == 0) goto L56
            if (r2 == r10) goto L52
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            goto L52
        L36:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L3e:
            boolean r1 = r8.Z$1
            boolean r2 = r8.Z$0
            java.lang.Object r4 = r8.L$1
            kotlin.jvm.functions.Function1 r4 = (kotlin.jvm.functions.Function1) r4
            java.lang.Object r5 = r8.L$0
            androidx.room.RoomDatabase r5 = (androidx.room.RoomDatabase) r5
            kotlin.ResultKt.b(r0)
            r14 = r1
            r13 = r2
            r15 = r4
            r12 = r5
            goto L9b
        L52:
            kotlin.ResultKt.b(r0)
            goto Lb2
        L56:
            kotlin.ResultKt.b(r0)
            boolean r0 = r16.K()
            if (r0 == 0) goto L83
            boolean r0 = r16.T()
            if (r0 == 0) goto L83
            boolean r0 = r16.L()
            if (r0 == 0) goto L83
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r11 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r0 = r11
            r1 = r18
            r2 = r17
            r3 = r16
            r5 = r19
            r0.<init>(r1, r2, r3, r4, r5)
            r8.label = r10
            java.lang.Object r0 = r6.f0(r7, r11, r8)
            if (r0 != r9) goto Lb2
            return r9
        L83:
            r8.L$0 = r6
            r0 = r19
            r8.L$1 = r0
            r8.Z$0 = r7
            r8.Z$1 = r1
            r8.label = r4
            java.lang.Object r2 = androidx.room.util.b.c(r6, r1, r8)
            if (r2 != r9) goto L96
            return r9
        L96:
            r15 = r0
            r14 = r1
            r0 = r2
            r12 = r6
            r13 = r7
        L9b:
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r11 = 0
            r10 = r1
            r10.<init>(r11, r12, r13, r14, r15)
            r2 = 0
            r8.L$0 = r2
            r8.L$1 = r2
            r8.label = r3
            java.lang.Object r0 = kotlinx.coroutines.i.g(r0, r1, r8)
            if (r0 != r9) goto Lb2
            return r9
        Lb2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.e(androidx.room.RoomDatabase, boolean, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Cursor f(RoomDatabase db2, a4.g sqLiteQuery, boolean z10, CancellationSignal cancellationSignal) {
        Intrinsics.h(db2, "db");
        Intrinsics.h(sqLiteQuery, "sqLiteQuery");
        Cursor W = db2.W(sqLiteQuery, cancellationSignal);
        if (!z10 || !(W instanceof AbstractWindowedCursor)) {
            return W;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) W;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? a.a(W) : W;
    }

    public static final int g(File databaseFile) {
        Intrinsics.h(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) != 4) {
                throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
            }
            allocate.rewind();
            int i11 = allocate.getInt();
            CloseableKt.a(channel, null);
            return i11;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(channel, th2);
                throw th3;
            }
        }
    }
}
