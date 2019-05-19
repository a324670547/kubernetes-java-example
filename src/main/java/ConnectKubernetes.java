import club.mydlq.kubernetes.example.get.GetService;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreApi;
import io.kubernetes.client.util.Config;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * - 描述：连接 Kubernetes 常用配置
 */
public class ConnectKubernetes {

    /**
     * 方式一：默认方式,从系统配置 $HOME/.kube/config 读取配置文件连接 Kubernetes 集群
     */
    public static void connectFromSystemConfig() throws IOException {
        // 设置默认客户端配置
        ApiClient apiClient = Config.defaultClient();
        // 设置默认 Api 客户端到配置
        Configuration.setDefaultApiClient(apiClient);
    }

    /**
     * 方式二：从指定文件读取配置文件连接 Kubernetes 集群
     */
    public static void connectFromConfig() throws IOException {
        // 从文件读取配置文件
        ApiClient apiClient = Config.fromConfig("d:/config");
        // 设置默认 Api 客户端到配置
        Configuration.setDefaultApiClient(apiClient);
    }

    /**
     * 方式三：Spring 中利用 @Value 读取 Resources 配置
     */
    public static void connectFromResourcesConfig() throws IOException {
        // 输入流从 resources 中读取 config
        InputStream in = new FileInputStream(new File("src/main/resources/config"));
        // 配置客户端
        ApiClient apiClient = Config.fromConfig(in);
        // 设置默认 Api 客户端到配置
        Configuration.setDefaultApiClient(apiClient);
    }

    /**
     * 方式四：通过 Token 连接 Kubernetes 集群
     */
    public static void connectFromToken() {
        /**创建默认 Api 客户端**/
        // 定义连接集群的 Token
        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IiJ9.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlLXN5c3RlbSIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi10b2tlbi1iNGo0aCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50Lm5hbWUiOiJhZG1pbiIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6IjkwMTQzMWYxLTVmNGItMTFlOS05Mjg3LTAwMGMyOWQ5ODY5NyIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDprdWJlLXN5c3RlbTphZG1pbiJ9.iwE1UdhB78FgXZJh4ByyOZVNh7M1l2CmOOevihOrY9tl_Z5sf3i_04CA33xA2LAMg7WNVYPjGB7vszBlkQyDGw0H5kJzIfL1YnR0JeLQkNk3v9TLyRqKJA2n8pxmJQIJP1xq0OPRGOfcA_n_c5qESs9QFHejVc5vABim8VBGX-pefKoJVXgu3r4w8gr1ORn4l5-LtHdQjSz3Dys7HwZo71fX2aLQR5bOPurkFKXqymcUoBYpWVsf-0cyN7hLRO-x-Z1i-uVpdM8ClpYSHv49eoDJePrcWpRp-Ryq6SNpGhiqCjjifEQAVHbr36QSAx8I1aamqLcpA0Da2qnunw52JA";
        // 定义 Kubernetes 集群地址
        String url = "https://192.168.2.11:6443";
        // 配置客户端
        ApiClient apiClient = Config.fromToken(url, token, false);
        // 设置默认 Api 客户端到配置
        Configuration.setDefaultApiClient(apiClient);
    }

    /**
     * 方式五：读取配置文件,通过 Token 连接 Kubernetes 集群
     *
     * 先创建一个 auth.properties 文件，然后里面设置两个参数：
     * - (1)、url：kubernentes 集群地址
     * - (2)、token：连接 kubernetes 的 token
     */
    public static void connectFromTokenByFile() throws IOException {
        /**创建默认 Api 客户端**/
        Properties properties = new Properties();
        // 加载properties文件
        InputStream is = GetService.class.getClassLoader().getResourceAsStream("auth.properties");
        // 加载输入流
        properties.load(is);
        // 读取token
        properties.getProperty("token");
        // 获取 Url 参数并定义 Kubernetes 集群地址
        String url = properties.getProperty("url");
        // 获取 Token 参数并定义连接集群的 Token
        String token = properties.getProperty("token");
        // 配置客户端
        ApiClient apiClient = Config.fromToken(url, token, false);
        // 设置默认 Api 客户端到配置
        Configuration.setDefaultApiClient(apiClient);
    }

    /**
     * 连接 Kubernetes 测试
     */
    public static void main(String[] args) throws Exception {
        /** 方式一：默认方式,从系统配置 $HOME/.kube/config 读取配置文件连接 Kubernetes 集群 **/
        //connectFromSystemConfig();
        /** 方式二：从指定文件读取配置文件连接 Kubernetes 集群 **/
        //connectFromConfig();
        /** 方式三：Spring 中利用 @Value 读取 Resources 配置 **/
        //connectFromResourcesConfig();
        /** 方式四：通过 Token 连接 Kubernetes 集群 **/
        //connectFromToken();
        /** 方式五：通过 Token 连接 Kubernetes 集群 **/
        connectFromTokenByFile();
        // 测试输出信息
        CoreApi coreApi = new CoreApi();
        System.out.println(coreApi.getAPIVersions());
    }

}
