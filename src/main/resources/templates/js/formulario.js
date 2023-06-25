const { useState } = React;

const App = () => {
    const [firstName, setFirstName] = useState("");
    const [statusOf, setStatusOf] = useState({});

    const updatedStatusOf = { ...statusOf };

    const firstNameOnChangeHandler = (text) => {
        updatedStatusOf.firstName = !/^[A-Za-z]+$/.test(text) ? "Inválido" : "Válido";
        setStatusOf(updatedStatusOf);
        setFirstName(text);
    };

    const [lastName, setLastName] = useState("");

    const lastNameOnChangeHandler = (text) => {
        updatedStatusOf.lastName = !/^[A-Za-z]+$/.test(text) ? "Inválido" : "Válido";
        setStatusOf(updatedStatusOf);
        setLastName(text);
    };

    const [username, setUsername] = useState(""); //Inicializando

    const usernameOnChangeHandler = (text) => {
        updatedStatusOf.userName = !/^(?=.*[a-zA-Z0-9])(?=.*[^a-zA-Z0-9_.]).{5,30}$/.test(
            text
        )
            ? "Invalid"
            : "Valid"; // Checking if the entered text met the conditions and updating the status of username
        setStatusOf(updatedStatusOf);
        setUsername(text);
    };

    const [password, setPassword] = useState(""); //Initializing the state variable "password" with empty string

    const passwordOnChangeHandler = (text) => {
        updatedStatusOf.password = !/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*]).{7,16}$/.test(
            text
        )
            ? "Inválido"
            : "Válido"; // Checking if the entered text met the conditions and updating the status of password
        setStatusOf(updatedStatusOf);
        setPassword(text);
    };

    //submit form handler
    const validacaoSubmissao = (e) => {
        e.preventDefault();
        let submit = "yes";
        for (const key in statusOf) {
            // Check if any fields are marked as "Invalid"
            if (statusOf[key] === "Invalid") {
                alert("Enter " + key + " in a valid format");
                submit = "No";
                break;
            }
        }
        if (
            firstName.length === 0 ||
            lastName.length === 0 ||
            username.length === 0 ||
            password.length === 0
        ) {

            alert(
                "Campo obrigatório!"
            );
            submit = "No";
        }
        if (submit === "yes") {
            alert("Salvo!");
        }
    };

    return (
        <div className="flex items-center justify-center">
            <div className="gap-y-5 flex flex-col items-center">
                <h1 className="text-2xl font-bold text-center">SignUp</h1>
                <form onSubmit={validacaoSubmissao}>
                    <div className="gap-y-5 px-5 flex flex-col items-center">
                        <div className="flex flex-row items-center justify-between">
                            <div className="w-[40%] flex flex-col items-start">
                                <label htmlFor="firstname">Nome Fantasia</label>
                                <input
                                    style={{ border: "1px solid black", marginRight: "15px" }}
                                    className="border-[1px] border-[#B7B7B7] rounded-full px-3 py-1 text-lg"
                                    type="text"
                                    name="firstname"
                                    id="firstname"
                                    value={firstName}
                                    onChange={(e) => firstNameOnChangeHandler(e.target.value)}
                                />
                                <p
                                    className={
                                        statusOf.firstName === "Invalid"
                                            ? "text-red-500"
                                            : "text-green-500"
                                    }
                                >
                                    {statusOf.firstName}
                                </p>
                                {/* Setting the color of text based on the status  */}
                            </div>
                            <div className="w-[40%] flex flex-col items-start">
                                <label htmlFor="lastname">CNPJ</label>
                                <input
                                    style={{ border: "1px solid black" }}
                                    className="border-[1px] border-[#B7B7B7] rounded-full px-3 py-1 text-lg"
                                    type="text"
                                    name="lastname"
                                    id="lastname"
                                    value={lastName}
                                    onChange={(e) => lastNameOnChangeHandler(e.target.value)}
                                />
                                <p
                                    className={
                                        statusOf.lastName === "Invalid"
                                            ? "text-red-500"
                                            : "text-green-500"
                                    }
                                >
                                    {" "}
                                    {statusOf.lastName}
                                </p>
                            </div>
                        </div>
                        <div className="flex flex-row justify-between items-center">
                            <div className="w-[49%] flex flex-col items-start">
                                <label htmlFor="username">Logradouro</label>
                                <input
                                    style={{ border: "1px solid black", marginRight: "15px" }}
                                    className="border-[1px] border-[#B7B7B7] rounded-full px-3 py-1 text-lg"
                                    type="text"
                                    name="username"
                                    id="username"
                                    value={username}
                                    onChange={(e) => usernameOnChangeHandler(e.target.value)}
                                />
                                <p
                                    className={
                                        statusOf.userName === "Invalid"
                                            ? "text-red-500"
                                            : "text-green-500"
                                    }
                                >
                                    {statusOf.userName}
                                </p>
                            </div>
                        </div>
                        <button
                            style={{ border: "1px solid black" }}
                            type="submit"
                            className="border-[1px] border-[#B7B7B7] rounded-full px-3 py-1 text-lg"
                        >
                            Submit
                        </button>
                    </div>
                </form>
            </div>
        </div>
    );
};

ReactDOM.render(<App />, document.getElementById("app"));
