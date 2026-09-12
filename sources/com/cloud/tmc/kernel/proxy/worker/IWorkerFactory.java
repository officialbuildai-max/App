package com.cloud.tmc.kernel.proxy.worker;

import com.cloud.tmc.kernel.annotation.DefaultImpl;
import com.cloud.tmc.kernel.node.Node;
import com.cloud.tmc.kernel.proxy.Proxiable;
import com.cloud.tmc.kernel.worker.IWorker;

@DefaultImpl("com.cloud.tmc.miniapp.defaultimpl.WorkerImp")
/* loaded from: classes3.dex */
public interface IWorkerFactory extends Proxiable {
    IWorker createWorker(String str, Node node);

    int workerType();
}
