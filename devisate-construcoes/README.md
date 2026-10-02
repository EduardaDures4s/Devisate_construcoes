# Devisate Construções — Sistema de Aluguéis e Manutenção de Equipamentos

## Sobre o projeto
Sistema para controle de equipamentos, empréstimos, agendamentos e manutenções da empresa Devisate Construções, substituindo o controle manual feito atualmente por planilhas, anotações e mensagens de aplicativos de conversa.

## Situação-problema
A empresa possui diversos equipamentos utilizados em obras e atividades de manutenção. O controle manual passou a apresentar problemas como:
- Equipamentos emprestados sem registro formal
- Dificuldade em localizar materiais
- Conflitos de agendamento entre obras
- Falta de histórico de manutenção
- Ausência de indicadores gerenciais
- Falta de controle sobre responsáveis por equipamento

## Tecnologias utilizadas
- **Java 17** com **Swing** (interface desktop)
- **MySQL** como banco de dados
- **Figma** para prototipação visual das telas

## Como rodar o projeto
1. Crie o banco executando `database/schema.sql` no MySQL.
2. (Opcional) Popule com dados de teste executando `database/seed.sql`.
3. Ajuste usuário/senha do banco em `src/main/java/com/devisate/conexao/ConexaoBD.java`, se necessário.
4. Importe o projeto como Maven na sua IDE (Eclipse, NetBeans ou IntelliJ).
5. Rode a classe `com.devisate.Main`.

## Estrutura de páginas
O sistema é dividido em três áreas, totalizando 21 a 23 telas mapeadas a partir dos requisitos funcionais.

### Área Pública (7 telas)
| # | Tela | Requisito(s) |
|---|------|--------------|
| 1 | Home / Landing institucional | — |
| 2 | Sobre a empresa | — |
| 3 | Catálogo de equipamentos | RF08 |
| 4 | Ficha do equipamento | RF09 |
| 5 | Login | RF01 |
| 6 | Recuperar senha | RF02 |
| 7 | Criar conta / Cadastro | — |

### Área do Usuário (4 telas)
| # | Tela | Requisito(s) |
|---|------|--------------|
| 8 | Perfil do usuário | RF25 |
| 9 | Solicitação de agendamento | RF10 |
| 10 | Histórico de empréstimos | RF25 |
| 11 | Histórico de agendamentos | RF25 |

### Área Administrativa (10 a 12 telas)
| # | Tela | Requisito(s) |
|---|------|--------------|
| 12 | Dashboard com indicadores | RF21, RF22 |
| 13 | Cadastro/lista de usuários | RF03, RF04 |
| 14 | Cadastro de categorias (equipamento e manutenção) | RF05, RF06 |
| 15 | Cadastro/lista de equipamentos | RF07 |
| 16 | Aprovação de agendamentos pendentes | RF11, RF12 |
| 17 | Registro de retirada + checklist com fotos | RF13, RF14 |
| 18 | Registro de devolução + comparação de checklist | RF15, RF16 |
| 19 | Abertura de Ordem de Serviço | RF17, RF18 |
| 20 | Encerramento de Ordem de Serviço | RF19, RF20 |
| 21 | Geração de relatórios | RF23 |
| 22 | Configuração de tarifas | RF24 |

Detalhes completos dos requisitos funcionais e não funcionais em [https://github.com/EduardaDures4s/Sistema-Devisate-constru-es-].

## Estrutura de pastas
```
devisate-construcoes/
├── docs/                              # documentação, requisitos, modelagem do banco
├── design/
│   └── paginas/                       # exports do Figma, organizados por área
│       ├── 01-area-publica/
│       ├── 02-area-usuario/
│       └── 03-area-administrativa/
├── database/                          # scripts SQL (criação, dados de teste, consultas)
│   ├── schema.sql
│   ├── seed.sql
│   └── queries.sql
├── src/main/java/com/devisate/
│   ├── Main.java                      # ponto de entrada da aplicação
│   ├── conexao/                       # conexão JDBC com o banco
│   ├── modelo/                        # classes de modelo (Usuario, Equipamento, ...)
│   ├── dao/                           # acesso a dados (UsuarioDAO, EquipamentoDAO, ...)
│   └── telas/
│       ├── publica/                   # telas da área pública (Login, ...)
│       ├── usuario/                   # telas da área do usuário
│       └── admin/                     # telas da área administrativa
└── .gitignore
```

## Links
- Figma: [https://www.figma.com/design/DYFBc2eEQ7zVSqeZKwC5Im/Devisate_constru%C3%A7%C3%B5es?node-id=0-1&t=yBIafmcmMeW9rnDX-1]

## Equipe
_[Maria Eduarda Durães Cruz Mesquita e Maria Eduarda Rangel Sousa]_
