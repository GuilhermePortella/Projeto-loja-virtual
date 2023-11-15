# pit2

## requisitos para buildar o projeto:
 - Java >13.
 - npm: >9.8.1
 - node: >18.17.1
 - MySql
 - Conta de developer: stripe.com
 - Conta de developer: okta.com

 - Para ter acesso aos scripts do banco de dados entre em contato comigo

## Instruções para o projeto angular ecommerce
- Va para a parta do  projeto /angular-ecommerce-2
- 1 npm install - > Para instalar as dependencias do projeto front end
- 2 npm start - > Para startar o projeto front end
 - ### certificados https:
 - baixe o programa :
  https://slproweb.com/products/Win32OpenSSL.html

 - vá para a entrada: Win64 OpenSSL v1.1.x Light.

 - Selecione o link de download MSI.

 - Após o download para o seu computador, execute o arquivo MSI.

 - Durante o processo de instalação, selecione todas as opções padrão.

 - Atualize a variável de ambiente do sistema para apontar para a instalação do OpenSSL.

 - A - Abra o Painel de Controle do Windows

 - B - Selecione Sistema > Configurações Avançadas do Sistema

 - C - Clique em Variáveis de Ambiente

 - D - Na seção Variáveis do Sistema, selecione a variável Path e clique no botão Editar.

 - E - No início do caminho, adicione: c:\Program Files\OpenSSL-Win64\bin;

 #### OBSERVAÇÃO: Certifique-se de atualizar com o diretório de instalação em seu computador.

 - F - Clique em Ok e prossiga para fechar todas as janelas de diálogo.

 #### Verificar a Instalação do OpenSSL

 - Abra uma nova janela de prompt de comando.

 - #### Digite o seguinte comando:

```
openssl help
```
 - Você verá a versão do OpenSSL instalada.

### Gerar Chave e Certificado Autoassinado
 - Abra uma janela de prompt de comando.
 - Navegue até o diretório do seu projeto Angular ecommerce.

 Crie um novo diretório para seus arquivos de saída.

 ```
 mkdir ssl-localhost
 ```

 ### Crie um arquivo de configuração para a utilidade OpenSSL.

- A - No diretório: angular-ecommerce

- B - Crie um novo arquivo chamado: localhost.conf

 - Abra o arquivo localhost.conf e insira o seguinte:
 ```

    # Não solicitar ao usuário ao gerar o certificado OpenSSL
    prompt = no

    # Referência à seção contendo o Nome Distinguido (informações sobre sua    empresa/entidade)
    distinguished_name = dn

    # País, Estado e Localidade (cidade)
    C = BR
    ST = São Paulo
    L = São Paulo

    # Organização e Unidade Organizacional (nome do departamento, nome do grupo)
    O = luv2code
    OU = Treinamento

    # Nome Comum (nome de domínio totalmente qualificado do seu servidor de site)
    CN = localhost
 ```

 - Salve o arquivo.

- Na janela do terminal, execute este comando para gerar a chave e o certificado. Certifique-se de inserir este comando como uma única linha.
 ```
   openssl req -x509 -out ssl-localhost\localhost.crt -keyout ssl-localhost\localhost.key -newkey rsa:2048 -nodes -sha256 -days 365 -config localhost.conf
```

 - Visualize o conteúdo do seu certificado. 
 ```
localhost.crt   localhost.key
 ```
 - procure o arquivo package.json
 - dentro desde arquivo busque por Scripts e adicione a seguinte linha: 
```
"start": "ng serve --ssl=true --ssl-key=./ssl-localhost/localhost.key --ssl-cert=./ssl-localhost/localhost.crt"
```
 
## Instruções para o projeto Java ecommerce

 - Abra uma janela de terminal/prompt de comando.
 - Navegue até o diretório do seu projeto Spring Boot ecommerce.
 - Na janela do terminal, execute este comando para gerar a chave e o certificado. Este é um comando longo; copie/cole na íntegra.

 ```
  keytool -genkeypair -alias luv2code -keystore src/main/resources/luv2code-keystore.p12 -keypass secret -storeType PKCS12 -storepass secret -keyalg RSA -keysize 2048 -validity 365 -dname "C=US, ST=Pennsylvania, L=Philadelphia, O=luv2code, OU=Training Backend, CN=localhost" -ext "SAN=dns:localhost"
```

- Edite o arquivo application.properties
- Adicione este trecho para configurações SSL do Spring Boot no final do seu arquivo application.properties.

  
```
#####
#
# HTTPS configuration
#
#####

# Server web port
server.port=8443

# Enable HTTPS support (only accept HTTPS requests)
server.ssl.enabled=true

# Alias that identifies the key in the key store
server.ssl.key-alias=luv2code

# Keystore location
server.ssl.key-store=classpath:luv2code-keystore.p12

# Keystore password
server.ssl.key-store-password=secret

# Keystore format
server.ssl.key-store-type=PKCS12
``` 
