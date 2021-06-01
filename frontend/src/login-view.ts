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
              <img
                src="/VAADIN/static/themes/jabber/images/avatars/1.png"
                @click="${this.avatarSelected}"
              />

              ${this.avatars.map(
                (avatar) => html`<img src="${avatar}" @click="${this.avatarSelected}" />`
              )}

              <img src="/VAADIN/static/themes/jabber/images/avatars/2.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/3.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/4.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/5.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/6.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/7.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/8.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/9.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/10.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/11.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/12.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/13.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/14.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/15.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/16.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/17.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/18.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/19.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/20.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/21.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/22.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/23.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/24.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/25.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/26.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/27.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/28.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/29.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/30.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/31.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/32.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/33.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/34.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/35.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/36.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/37.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/38.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/39.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/40.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/41.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/42.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/43.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/44.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/45.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/46.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/47.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/48.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/49.png" />
              <img src="/VAADIN/static/themes/jabber/images/avatars/50.png" />
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
