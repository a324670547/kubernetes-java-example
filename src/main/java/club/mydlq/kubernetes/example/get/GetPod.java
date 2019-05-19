package club.mydlq.kubernetes.example.get;

import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;

/**
 * - 描述：获取 Pod
 * - API版本： v1
 */
public class GetPod {

    /**
     * 获取全部 Namespace 下的全部 Pod 列表
     */
    public static void getAllPod() throws ApiException {
        // Api对象
        CoreV1Api api = new CoreV1Api();
        // 获取全部 Namespace 下的 pod 列表
        V1PodList podList = api.listPodForAllNamespaces(null, null, null, null, null, "true", null, null, null);
        for (V1Pod item : podList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的 Pod 列表
     */
    public static void getNamespacePodList(String namespace) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 的 Pod 列表
        V1PodList podList = api.listNamespacedPod(namespace, null, null, null, null, null, null, null, null,null);
        for (V1Pod item : podList.getItems()) {
            System.out.println(item.getMetadata().getName());
        }
    }

    /**
     * 获取某个 Namespace 的某个 Pod
     */
    public static void getNamespacePod(String namespace, String podName) throws ApiException {
        // 设置 Api 客户端
        CoreV1Api api = new CoreV1Api();
        // 获取某个 Namespace 下的 Pod
        V1Pod pod = api.readNamespacedPod(podName, namespace, null, null, null);
        System.out.println(pod);
    }

    /**
     * 获取 Pod 信息
     */
    public static void main(String[] args) throws Exception {
        // 连接 Kubernetes 集群
        ConnectKubernetes.connectFromTokenByFile();
        // 获取全部 Namespace 下的全部 Pod 列表
        getAllPod();
        // 获取某个 Namespace 的 Pod 列表
        getNamespacePodList("kube-system");
        // 获取某个 Namespace 的某个 Pod
        getNamespacePod("kube-system","PodName");
    }

}
