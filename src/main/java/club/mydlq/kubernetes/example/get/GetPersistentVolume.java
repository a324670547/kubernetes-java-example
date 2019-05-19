package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1PersistentVolume;
import io.kubernetes.client.models.V1PersistentVolumeList;

/**
 * - 描述：获取 PersistentVolume
 * - API版本： v1
 */
public class GetPersistentVolume {

    /**
     * 获取全部 PV 列表
     */
    public static void getAllPV() throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取全部 pv 列表
        V1PersistentVolumeList PVList = api.listPersistentVolume(null,null,null,null, null, null, null, null, null);
        for (V1PersistentVolume item : PVList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 PV
     */
    public static void getPV(String PVName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 PV
        V1PersistentVolume PV = api.readPersistentVolume(PVName, null, null, null);
        System.out.println(PV);
    }

    /**
     * 获取 PV
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 PV
        getAllPV();
        // 获取 PV
        getPV("PVName");
    }

}
