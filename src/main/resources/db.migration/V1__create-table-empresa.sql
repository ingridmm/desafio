create table empresa(
                        id bigint not null auto_increment,
                        nomeFantasia varchar(100) not null,
                        cnpj varchar(14) not null,
                        logradouro varchar(100) not null,
                        bairro varchar(100) not null,
                        cep varchar(9) not null,
                        complemento varchar(100),
                        numero varchar(20),
                        uf char(2) not null,
                        cidade varchar(100) not null,

                        primary key(id)

);

create table fornecedor(
                        id bigint not null auto_increment,
                        nome varchar(100) not null,
                        email varchar(100) not null,
                        cncnpjOuCpfpj varchar(14) not null,
                        logradouro varchar(100) not null,
                        bairro varchar(100) not null,
                        cep varchar(9) not null,
                        complemento varchar(100),
                        numero varchar(20),
                        uf char(2) not null,
                        cidade varchar(100) not null,

                        primary key(id)

);
