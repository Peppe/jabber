import {
  LitElement,
  html,
  query,
  property,
  customElement,
} from "lit-element";
import '@vaadin/vaadin-text-field/vaadin-text-field.js';
import "@vaadin/vaadin-text-field/vaadin-password-field.js";
import '@vaadin/vaadin-button/vaadin-button.js';
// @ts-ignore
import * as glyphs from "./vaadin-icons-bundle.js";


@customElement("login-view")
export class LoginView extends LitElement {
  @property()
  label: string | undefined = undefined;

  @query("#loginForm")
  loginForm!: HTMLFormElement;

  avatars: string[];

  createRenderRoot() {
    return this;
  }

  constructor() {
    super();
    this.avatars = Array(50).fill(null).map((_, i) => "/VAADIN/static/themes/jabber/images/avatars/"+ (i+1) + ".png");
    console.log(this.avatars);
  }

  render() {
    return html`
      <div
        class="flex flex-grow login-view-wrapper items-center justify-center"
      >
        <div
          class="border border-contrast-20 flex flex-col rounded-m bg-base p-m"
        >
          <form
            id="loginForm"
            name="login"
            method="POST"
            action="login"
            class="flex flex-col"
          >
            <h3 class="m-0">Vabber</h3>
            <vaadin-text-field
              name="username"
              label="Your displayed name"
              autocapitalize="none"
              autocorrect="off"
              spellcheck="false"
            >
              <input type="text" slot="input" autofocus />
            </vaadin-text-field>

            <div>Select avatar</div>
            <div class="login-view-avatars">
              ${this.avatars.map(
                (avatar) => html`<img src="${avatar}" @click="${this.avatarSelected}" />`
              )}
            </div>

            <vaadin-button
              theme="primary contained"
              @click=${() => this.submit()}
              >Start chatting</vaadin-button
            >
          </form>
        </div>
      </div>

      <div class="image-attribution p-s">
        Background image by
        <a href="https://flickr.com/photos/wrack/28987657184">Wegdekstreepje</a
        >. Avatars by
        <a href="https://www.freepik.com" title="Freepik">Freepik</a>.
      </div>
    `;
  }

  connectedCallback() {
    super.connectedCallback();
  }

  avatarSelected(avatar: MouseEvent) {
    console.log((<Element>avatar.target)!.getAttribute("src"));
  }

  submit() {
    this.loginForm.submit();
  }
}
