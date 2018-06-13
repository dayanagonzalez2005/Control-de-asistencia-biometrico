-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-11-2017 a las 20:01:41
-- Versión del servidor: 10.1.25-MariaDB
-- Versión de PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `huellas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `somhue`
--

CREATE TABLE `somhue` (
  `id` int(11) NOT NULL,
  `huenombre` varchar(100) NOT NULL,
  `huehuella` blob NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `somhue`
--

INSERT INTO `somhue` (`id`, `huenombre`, `huehuella`) VALUES
(1, 'jnjj', 0x00f87e01c82ae3735cc0413709ab71f0e0145592c3b8ba1d69d44f09723c7aecae7eecc10dd4de6cf49c1958f3e1b428f7d513bb691f9f5095ee17f44c4fb9ce4c3b3f053344b90c1d1c9eec52e6509fee1791a966804e9731fb6bc45b5e2a83bf1b8566875b6477817482382eba292605691cb155359eeaf2e52aa55562246915577439b28352bdbb4005f5cb7f01f594b31d6c9c756076ade25efdeeb18a8f0f51da3caf3a903ee658752768e33895bf6ce4c548f71dd0bce12f63dff0855164e7d18d05038aa4d047bbb14f242289514fe36e0917b953b6fb1e2db7f5f0bb6a4267d04e5c2cb2514b16270ed5ba926d06a44e18c7ed0433c0f1c310306c28cc085fb9d5cbc7ad3469021d17230bc257435d1894328ac705bd6d3fa963bc501e25a4bab33d34380ab5ad6650d9af03db1edd569b39ab01f83d51bba33d25f86feb88001acac4187685b61417fa8e80313c96e6de4ddb59cc0d4b493a1c0636d370816b9fc86121076db7de3e9aad1688426ed971efce41facb1f7d0ae3117646686f00f87e01c82ae3735cc0413709ab71f089145592b70b8624076b993f3d15131b08528cc0154be430fb5ee298b8a6b29548c0b9061e37b3a3271c7a808def41618f39fd619c9a4f552877ea51cd26f80d7355940e5c9708b096481de9d1adb935fa91f4139e905af5123189973c02ac50b9044e28f349e5c0745896c234106044c8dfe2996c26fe6708a74bf28fa56d1cfae5dcec9324c8121d0ca6acb16c8fddccffee7e0d7647da5bd02db659878054833aef670377c0258b077b793d32dc4c956c653663d5d2e34d22505867302cb45cf824b98df9f6de3099c072ae7cd302385a87ab09620b9b07c66c82298db602404ee0d97781f7f4b924b96b1e499fc550b54b26fc3fee76d27aba882f8cf9b34587f51b56b21874bde10dcf90b9cca9e2179e3922cd36f97ef3dcccbdb363374b99d4467eab8a51d3dcd7adc790ec14708d69f81bdf22770a8d4c7195b8f4377e18b3fb607be3f81e7fdc469483f23989853c20f98acf1c22a5120eb7d14da0d5b75351404d64271eee79674fec68b04e176f00f87e01c82ae3735cc0413709ab7170f9145592744b05d36362190ad701ac9cdf7c6103a04fb7f14f7eca6dcbd079440afb9b62d2ba02afb38580c44dd724695d270f89dfdf2acdebd19d5d0b569a51c20cbcbad39f2c9dc6b24ecb56bef70cc885f0886e22e33c2665062bb2e061bb2ba27c8e03b5451073a1e62c4b5d155fe044e04192ad4a5fb011a5531c3e52663fc7d50177645d13415dcc855e2fac25da58353b43c3ee7beb52e8075d8373c58b27514e1831b3ba1c9cc8a3a4bbcab29657153104f4f6863e2c8470e81f921bdcc438b3d9d2cb876275f33c04ad5ae00a6e5c4a58d9a0be3ba71719f0da6f720e2fe028e89c53e07db2273fca909faefe5e5b8b449783bca1068ed743e599a2b20d90941a5bb639abdb4b71a83758dc2f1b0fcc3f17a3f7840ed891df6f58314a541b84036ea7fffef22205dc874d3f1ddc06751d5f826b5ab5f0edefca8e171d63207d7a8bc95a9477a307229b5b0d7cee7f9a4a36791a05fd9648fd1c71eef967ccf9322f8c9138791daaa7a49fe0f61b6f00e88001c82ae3735cc0413709ab717082145592dfd095f89b360b5bde26ec4e78319ebe5779b8a92f71550fcc5232cae57338b1fbc2f8437fee1709065d9ffe601f455f07dbf8d71624caea859b93316bc072fc5c1f863e77a1a8f74e7f924ef100b39ba0dd989f3a0421f7f11943bb9ef2c453aee2a52b5b408b8da0a8bcc401da3e986c29818632a9c357b855889627f159bd7677e0159c2bef5581872b1b78b3a0b34788c5ab3b8df5474b22559b75b557f49d9cd7a0fd788df08c63e1f8717ec212db59ec07c009fbb7a48e25dd1365c4217de742db17549e6348e2a87cc8ddf741bbd162bb297a93d83bb88b24cd518c31e4fd9685b67ef659d5f4929fa540627130bdb6915a4d997694cefe6c539946021963a01405d61d04b107425251edfb97baf5c28200b5a4835b93b65de18a7f73a7eb67f9a8e54919288101a1cb70a88b77182d8493cb382b91dfec9d871c0683881667d6fa7feed4b5397a8a7a8b2488e7430ba7bcae1943f93ce5f2d91990475f41489bf5600cdf452e0f1a7b7a5f176f00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000),
(2, 'heider', 0x00f87f01c82ae3735cc0413709ab71b0e0145592549181544c4f71b3da9846207a29d41d4f0d8b74024f4611d17204bcdfd1eb32478c4db5b460451290785123ffc3c1de8bd07ec9d1b66972cdca1489cbe679f6a504f6ad86b6af13657df15a53ae84b57bfdf163e641d91e4834a103171046ac0cb101832cab66f2c174c7ec1853dfd43f630807ce4a220634aa19baa661154c08f68ab02f445d8c51f01b8d890377b58ecdc5fcd2c77809b50d46a6fc26fa192aa6b5a87bf143e095683d2b295ecedfef69c885edec1607951a3eda248254d5f64eac5c92e6d7319dbc4577671d8dbf015c3c164cf83fcdf2919a45174e4ae9bdfb0def9c0a4a052a6ee3b8063d415be6ea7b89dada4c674ebc443e69357d33010d973365bbc53ae416844093dda7d69f56b1beda65882ea32e93db67658449181edb96c8822a0123de711eeb338ff25c356a7593947fa6ebdd77855028f7242fbe07781be57bab7e82262436e93335dcedfd91b2f3453d659fbe5479ddee63e845dd0e30d4d8a948d398c13650a56f00f88001c82ae3735cc0413709ab71f0fc145592407bae95595136cfdbfbf7f62de20f43416c1800755dc1f13e2d1b8ce4c2ffe8bea9a4bd208674e22c152695a8268aba0f83b0a88ee9aabd458b99a89d0b5abc53a23932999f57aedfda707b0cc4e7952570e4d3bdb79ab504e5df9ff93195024b59a6293d6fb8df153fd8152f07c51629a3f13ccf0b93402d1e8c497cf96f832010d3204046dbb8e7f1ac12c9713ffc6f8ff5ed72c6763be5631825b509bd90685692849ecc434a54c2c8f8664f7991485d6aaef2cf0b21bb046450c0dffeaec2d6ccc4ca0f0d4491d7d33546cadb6a52c6829be7cfa414824811f9e99d333cf8885ad7c9c464eee9047ae64093584f388dc02c3d27863ca3e6f31bad0cc2a1948cc2831141ce60c54156614754b1a8d7d15cf003f223442b5849d5042981dc142dca0aeb105b490ac2e621ff36dc43db8ecbe54fa1c5364656a69ea0f2032b6cac6eb39252be7b7c8d9f182a718f93bec924d14fcfb288104f224fd4f4674ecd4b80d2eeef6e11a6d11106ed046e296f00f87e01c82ae3735cc0413709ab7130d11455923f3bad82f9e10cf3d7e167756c77159b471bd4d2b438155a06035a48dbc8d0a1a1b58feaa59f95f37cf23be49d298cc6dd6d29cf57726765ac5f0e0df9b49276b365049e490a212b4a153ce005cf8c4fc417a73e056480bec3b3b9264bf0a0f2ea2640091d13c6d151afdd64dbf6f0892e4748c26a69d5f550dc594819e5654d2f4a8a72c1beaf4273d57c28777fe4e5e18255e4cb8f5119638272798916691f9e8f9ec9e626516731caf4f18021996fb476c6437d0469e6f6b1b885f37a4355a23f10eff70a77eedeb8c233b8ae0f1153d20b23b4b2890b1c155e44d58f924afa62af0eae28f29e555acf37703f2791fcc714a400bacdf3abbc8bb1652ccc799344fabe1c60776f33a3a9cd3d7bb6259e853e656aa01f298e18d30c0bdac58cf35983b30265204f20fca06d29982dfc45a154c86e99bd0acf99ffba850476e724669564187a454deb1e5cef84515929b9a1c93c26ffcc8022a43463118c92b4fd8a2ab2f0ba95d8452789cfd36f6f00e88001c82ae3735cc0413709ab71b0e6145592a575dcd0a38ca9299bbb21bb1d25c4a3fa32347f6cd0f27f6df3fadbbbef47c1356fa07564807aa261e56661a8e96586b7c9385032916e23d2d4794ef4cfda4623b9570b45b555f4259319610c8167b7528f5c3a64a66fca13d7b0f2cdb3373157d5d37405270c8b251b20d63beae1f82ce60c914ef52532b05040c91cd9aad851b028e627b90da79610cf53d30a16f92e3359e4fd8a9142daf701f076b4d376948db8cf2c41172cf831b71e59919f6a4dc56096afae25f9a3b419fab5fda02c98ed550344fce97f0e92a4a6c58832489595ffa6d2ac733f7638b058e85263dc8e2403a60e034f6ad22c092426bcee0dbfa8e85e0f6b24a61c43848da1b216166ebde41827a89fee22b66e6b8d806251672b1711443cc2d471f1c2dbc74b7c84a388fedaaed4ea5f04d3ee467377bf274013ec0f26349860e064eacb4c4c03fe5c89907d36d2886c7955a67e4fccbd654a585b4f9eb10ca16e661268fae5da67e98d4b9014b153af1ad02f4e425f85d56f00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000),
(3, 'elias', 0x00f88101c82ae3735cc0413709ab71f09b145592dc80129fe53e2812c310101820d15dda7adf8a3358fa4e653f51d82ccf96b09e3dd103f1a651c74104523af122e8a8cb2051e4e44c1cecd73c4385871001a72ba4ed46e7af1870ee0e38a79248f62e3ee084948732b45039fcf748b2e3b63444488398099c6ada890e905d335f8ad54c49195cc5c4fcdce26ecb8d4098d9c21a343c387a5fb3c828ba028b944ef97d2f9b89a425e847e91646ef32138aead57366bfc2797ba9b65de0aabb8549e4bda444f401bc72e547fd3798ae44f96e27988fc9af1491bbb58e2c4bafccc637df85dd33cdca70f5fbc537f6b0953824979d3f893b6f1599c7f06e0f1e23e94476a2c97ca81e8a16311fea24200e68356750b9bce1d94bd396dcbf57384f4d9c59c26d9bea41b56a986049b76b0861bc53e67f1aa2259a63c8872199093fda101a1bffb56eb5bb69102db7adb9993c25347d6904d3d6ec30334a8a4dff41ece41bc39d10159f42e7e033d3372192caf5d5e1dd034f58558089ef84938ab6100329e46b6f00f87f01c82ae3735cc0413709ab71b094145592526ac051827dde6aa3b08813321fc6e810c6241cffea36966cb4ee10b18c084f56bb5b29c70a24a2d6bc3da60392ac47249132f659eee648450db0cfebf26edc50faaaab4ab8163fe5d74a53257b603fc18bc6b643037404bcfb38a6695741f5e90873a51b0da4fc3007d0d3150fbdfa753e2034272b2cc898b9f77d6a6a7ffa12572cdd485ad648df3d4b4535f3e0624abf35135138ab9a7711d8001f90e4b7740cd72912fce623c653041bf50734ac90d1bbf7c06d92e1ce3e0f3145a5806703fd7e36e6742794826d085a60b737cb34cb8d0af80943979fbc11e96a8d06e05fb866d2adb095e4fad344057be70ee334efefbae90bd5f9e722d96eb3d806cfe8cedc2d6278abfc0e84d266774f969c85b667fce7a3e6eb0d320789b4ae127cd68eeb09a59ce7e9ff88d11ad5bea96877f2109521a51e9ade006d7ac1b274eb0f322446ff260b7ae9c2ebea0f1db3cfd1442c9794881c878b0ac2218d585eadc2c46356d196d26e49f62bef5161c76f00f88001c82ae3735cc0413709ab71f09f145592bf7e3cc2915ffaa76d410cc9b80cf35210be20428cb982e9d3b7de9f264e467e3392e188ed3f1c57cd41490d0c40409fde71028d92c440611087d658b6c38df3fc88d03346a6bd1103602a22bd86f0254d9d8861c91bda7177eba8caadd764eee25e82755fef40c0f7c35760e4d95a9d43f51e69f8a9f8ad9e06a9c28e5ee8a023099593ba9c3a7f41506b62aa656cecd650de52ff2d650861e0d2a79786b59091de43511772e4cfb25911486211fa85b7f742af61addfe8e1d37d12b203f35cfde6a0935cc6be20c3ce40bb8e08cb6717378900b04045af98614e951df9659b3564576212949baca91edbff86d8700175543fcd30653a772bfbf1855a42b82eeb2c2aefdecb2b3765dcd913331f839082947b730948aab6c76a8bd9d3ec50f28bb85105f1b3f9526ad1871d1dc064a28ef41e633e96fc3f1e456871fc2cc54760327ab66380f1be4b5a05a0b18203db8b6b2a9f19f97f6110a7bb7d1c52b589d994f727345b0d74d18bcddd467b8ace6f00e83801c82ae3735cc0413709ab71b0e3145592bd1dfba0c86cc686d499e04d3278ac1561830c2bff4bd17c2008baa7ac8b09959587cffd8fb537f426dbce222b19b27d911612a2808055c5b85535958f4fb34f7fa646f98e1acc234c9897baf5ed048a0034b1a8608f31654fca60e5d56c0bffb3bb63713005b62dce7bb8675df6ca92995207c950e1a51b0d700fee6c4b19bac7a9538933c123c0fa428874e58b8da8df05bb8ab308cb8308aa8a663c2e1d3fe24f07b3d43b296193d7826176f4035086baf9257af30b84464951802dbc65c8587eff0257c0f1ba62d2acf865d66486ccff463e155b4d805ee7aacfc3376f5c133a255a85abdba0dc6a6334bcf09f606e810f95ca314d514e141a2ec182fa2812af47829e9d997e5cbe2ec9ac0f54d6df05cbf3ea534eae1e9dc2c806335bfd5707fe93fde92dbb6f00000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `somhue`
--
ALTER TABLE `somhue`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `somhue`
--
ALTER TABLE `somhue`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
